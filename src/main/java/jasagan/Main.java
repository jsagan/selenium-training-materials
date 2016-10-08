package jasagan;

import jasagan.announcement.Announcement;
import jasagan.announcement.AnnouncementCategory;
import jasagan.announcement.Location;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
	public static void main(String[] args) {
		Gumtree gumtree = new Gumtree(new FirefoxDriver());

		boolean isValid = gumtree
				.addAnnouncement(
						Announcement
								.builder()
								.type(AnnouncementCategory.TRAINING_COURSES)
								.location(Location.LUBLIN)
								.title("Prezentacja JUG")
								.description("Prezentacja JUG. Duża aula UMCS wydział Informatyki.")
								.email(System.getProperty("login"))
								.image(new File("/home/jasagan/Pobrane/Java.jpg"))
								.build()).isValid();

		if (!isValid)
			throw new RuntimeException("...");

	}

}
