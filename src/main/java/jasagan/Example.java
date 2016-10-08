package jasagan;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jasagan on 04.10.16.

 */

public class Example {
@SneakyThrows
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("t");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("est");
driver.quit();
    }

}
