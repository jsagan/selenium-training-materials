package jasagan.announcement;

import jasagan.SeleniumUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class AnnouncementForm {
	private final WebDriver driver;

	public AnnouncementForm title(String title) {
		SeleniumUtils
				.waitForElement(() -> driver.findElement(By.name("Title")))
				.sendKeys(title);
		return this;
	}

	public AnnouncementForm email(String email) {
		SeleniumUtils
				.waitForElement(() -> driver.findElement(By.name("Email")))
				.sendKeys(email);
		return this;
	}

	@SneakyThrows
	public AnnouncementForm description(String description) {

		SeleniumUtils.waitForElement(
			() -> driver.findElement(By.id("description-frame"))).sendKeys(
			description);

		return this;
	}

	@SneakyThrows
	public AnnouncementForm addImage(File image) {

		SeleniumUtils.waitForElement(
				() -> driver.findElement(By.id("upload-btn"))).click();

		selectFileInDialog(image);

		waitForLoader();

		return this;
	}

	private void selectFileInDialog(File image) throws AWTException,
			InterruptedException {
		StringSelection stringSelection = new StringSelection(
				image.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);

		// imitate mouse events like CTRL+L, CTRL+V, ENTER
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	private void waitForLoader() throws InterruptedException {
		Thread.sleep(TimeUnit.SECONDS.toMillis(10));
	}



	@SneakyThrows
	public PreviewResult preview() {

		SeleniumUtils.waitForElement(
				() -> driver.findElement(By.id("postPreview"))).click();

		Thread.sleep(TimeUnit.SECONDS.toMillis(5));

		boolean isValid = driver.findElements(By.id("postPreview")).isEmpty();
		return new PreviewResult(isValid);
	}
}