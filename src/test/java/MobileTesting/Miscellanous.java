package MobileTesting;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Miscellanous extends BaseTest {

	@Test
	public void MiscellanousDemo() throws MalformedURLException, InterruptedException
	{	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//Landscape Test
		DeviceRotation landScape= new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		
		driver.findElement( By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		  driver.setClipboardText("aniket123");
		driver.findElement(By.id("android:id/edit"))
		.sendKeys(driver.getClipboardText());
		//Thread.sleep(3000);
		 String alertTitle=driver.findElement(By.id( "android:id/alertTitle")).getText();
		   Assert.assertEquals(alertTitle, "WiFi settings");
		   //Cpoy paste or copy to clipboard
		  
	    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	  System.out.println("The title is :-"+alertTitle);
	    
	     driver.pressKey(new KeyEvent(AndroidKey.BACK));
	     driver.pressKey(new KeyEvent(AndroidKey.HOME)); 
	   
	}
	
	
}
