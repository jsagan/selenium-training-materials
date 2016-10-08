package jasagan.announcement;

import jasagan.SeleniumUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AddAnnouncementModule {
	private final WebDriver driver;

	public static AddAnnouncementModule goToAddAnnouncementModule(WebDriver webDriver) {
		webDriver.get("https://www.gumtree.pl/post.html");
		return new AddAnnouncementModule(webDriver);
	}

	public LocationSelection category(AnnouncementCategory announcementCategory) {
		selectListItem(announcementCategory.mainType);

		selectListItem(announcementCategory.subType);

		selectListItem( announcementCategory.specificType);

		return new LocationSelection(driver);
	}

	private void selectListItem(String item) {
		SeleniumUtils.waitForElement(
				() -> driver.findElement(By.xpath(String.format("//span[text()='%s']", item)))).click();
	}

}
