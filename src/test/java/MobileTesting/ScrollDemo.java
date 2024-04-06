package MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() throws InterruptedException
	{	
		driver.findElement(AppiumBy.accessibilityId( "Views")).click();
		//scroll until webelement found
	   // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"WebView\"));"));
	 
		//just scroll 
		boolean canScrollMore; 
	 do 
	 {
	   canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	        "left", 100, "top", 100, "width", 200, "height", 200,
	        "direction", "down",
	        "percent", 3.0
	    ));
	 }while(canScrollMore);
	 Thread.sleep(4000);
	 
		 
	 
	}
}
