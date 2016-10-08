package jasagan;

import jasagan.announcement.Announcement;
import jasagan.announcement.AnnouncementCategory;
import jasagan.announcement.Location;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import lombok.SneakyThrows;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
	public static void main(String[] args) {
		Gumtree gumtree = new Gumtree(new FirefoxDriver());
		File jugLogo = copyToTemp(Main.class.getResource("/jug.jpg"));

		boolean isValid = gumtree
				.addAnnouncement(
						Announcement
								.builder()
								.type(AnnouncementCategory.TRAINING_COURSES)
								.location(Location.LUBLIN)
								.title("Testy i automaty na przykładzie selenium")
								.description(
										"Prezentacja 'Testy i automaty na przykładzie selenium'. Duża aula UMCS wydział Informatyki 3-cie piętro.")
								.email("email@example.com")
								.image(jugLogo)
								.build()).isValid();

		if (!isValid)
			throw new RuntimeException("...");

	}

	@SneakyThrows
	private static File copyToTemp(URL resource) {
		File file = File.createTempFile("jug", ".jpg");

		try (InputStream input = resource.openStream();
				OutputStream output = new FileOutputStream(file)) {
			IOUtils.copy(input, output);
		}
		
		return file;
	}
}
