package MobileTesting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LongPress extends BaseTest {
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{	
		driver.findElement(AppiumBy.accessibilityId( "Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
	    driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	    WebElement ele = driver.findElement(By.xpath( "//android.widget.TextView[@text='People Names']"));
	    LongPressAction(ele);
	    /*((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
	    		ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));*/
	    String menutext=driver.findElement(By.id( "android:id/title")).getText();
	    Assert.assertEquals(menutext, "Sample menu");
	    String menutext2=driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).getText();
	    //Assert.assertEquals(menutext2, "Sample action");
	    Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).isDisplayed());
	   // Thread.sleep(5000); 	
	    
	
	}
	

}
