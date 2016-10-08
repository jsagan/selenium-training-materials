package jasagan.announcement;

import jasagan.SeleniumUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class LocationSelection {
	private final WebDriver driver;

	public AnnouncementForm location(Location location) {
		selectListItem( location.district);
		selectListItem( location.city);

		return new AnnouncementForm(driver);
	}

	private void selectListItem(String item) {
		SeleniumUtils.waitForElement(
			() -> driver.findElement(By.xpath(String.format("//span[text()='%s']", item)))).click();
	}
}
