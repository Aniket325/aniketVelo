package MobileTesting;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseTest {

	@Test
	public void Appiumtest() throws MalformedURLException
	{	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement( By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit"))
		.sendKeys("aniket123");
		 String alertTitle=driver.findElement(By.id( "android:id/alertTitle")).getText();
		   Assert.assertEquals(alertTitle, "WiFi settings");
	    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	  System.out.println("The title is :-"+alertTitle);
	}
	
	
}
