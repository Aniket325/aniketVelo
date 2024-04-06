package MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class DragandDrop extends BaseTest{
	@Test
	public void SwipeDemoTest() throws InterruptedException
	{	
		Activity activity=new Activity(null, null);
		driver.findElement(AppiumBy.accessibilityId( "Views")).click();
		driver.findElement(AppiumBy.accessibilityId( "Drag and Drop")).click();
		WebElement sourse = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) sourse).getId(),
		    "endX", 850,
		    "endY", 750
		));
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
		
		
	}
	 

}
