package jasagan;

import jasagan.announcement.AddAnnouncementModule;
import jasagan.announcement.Announcement;
import jasagan.announcement.AnnouncementForm;
import jasagan.announcement.PreviewResult;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class Gumtree {

    private final WebDriver driver;

    public Gumtree login(String login, String password) {
        driver.get("https://www.gumtree.pl/login.html");
        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password + "\n");
        return this;
    }

    public PreviewResult addAnnouncement(Announcement announcement) {
        AnnouncementForm form = AddAnnouncementModule.goToAddAnnouncementModule(driver)
                                                     .category(announcement.getType())
                                                     .location(announcement.getLocation())
                                                     .description(announcement.getDescription())
                                                     .email(announcement.getEmail())
                                                     .title(announcement.getTitle());

        announcement.getImages().forEach(form::addImage);

        return form.preview();
    }
}
