package jasagan;

import java.util.function.Supplier;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {

	@SneakyThrows
	public static WebElement waitForElement(Supplier<WebElement> condition) {
		WebElement result = null;
		long start = System.currentTimeMillis();
		while (result == null || elementIsNotVisible(result))
			try {
				if (System.currentTimeMillis() > (start + 1000 * 20))
					if (result == null)
						throw new ElementNotFound();
					else
						break;
				result = condition.get();

                if (result == null)
				    Thread.sleep(100);

			} catch (Exception e) {
				if (System.currentTimeMillis() > (start + 1000 * 20))
					throw new ElementNotFound(e);

			}

		Thread.sleep(1000);

		return result;
	}

	private static boolean elementIsNotVisible(WebElement result) {
		try {
			return !result.isDisplayed();
		} catch (Exception e) {
			return true;
		}

	}

	public static class ElementNotFound extends RuntimeException {

		/** serialVersionUID */
		private static final long serialVersionUID = 1L;

		public ElementNotFound() {
			super("Element not found");
		}

		public ElementNotFound(Throwable cause) {
			super(cause);
		}
	}

}
