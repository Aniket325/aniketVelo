package MobileTesting;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void BrowserTest() throws InterruptedException {
		
		 driver.get("http://google.com");
		String Title = driver.getTitle();
		 System.out.println(Title);
		WebElement SearchOnGoogle = driver.findElement(By.xpath("//*[@name='q']"));
		SearchOnGoogle.sendKeys("Virat");
		SearchOnGoogle.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
	}
}
