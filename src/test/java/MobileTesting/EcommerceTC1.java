package MobileTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC1 extends BaseTest {

	@Test
	
	public void fillform() throws InterruptedException 
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
	    
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja");
	    driver.hideKeyboard();
	    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    String country= driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']")).getText();
	    Assert.assertEquals(country, "Aruba");
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    Thread.sleep(4000);
	
	}
	
}
