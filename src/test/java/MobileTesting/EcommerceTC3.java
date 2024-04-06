package MobileTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class EcommerceTC3 extends BaseTest {

	@Test
	public void ProductSelect() throws InterruptedException 
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja");
	    driver.hideKeyboard();
	    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    String country= driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']")).getText();
	    Assert.assertEquals(country, "Aruba");
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    
	     driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"PG 3\"));")).click();
	     //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));")).click();
     
	    int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	    for(int i=0;i<productCount;i++)
	    {
	    	String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    	if(productName.equalsIgnoreCase("PG 3"))
	    	{
	    		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	    	}
	    	
	    }
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Thread.sleep(4000);
	   WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		String productNameInCart=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	   Assert.assertEquals(productNameInCart, "PG 3");
	
	}
}
