package MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC1i extends BaseTest{
 
	@Test
	public void loginPage() throws InterruptedException
	{
		 driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Western Sahara\"));")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("puja");
	    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    
	    Thread.sleep(3000);
	    
	    
	    
	    
	}
	
	
}
