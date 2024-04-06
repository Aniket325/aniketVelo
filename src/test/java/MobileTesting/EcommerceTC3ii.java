package MobileTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC3ii extends BaseTest{
	@Test
	
	public void addtocartproduct() throws InterruptedException {
		WebElement ClickOnDropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		ClickOnDropdown.click();
		WebElement selectCountry = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		selectCountry.click();
		WebElement Entername = driver.findElement(By.id( "com.androidsample.generalstore:id/nameField"));
		Entername.sendKeys("Shobha");
		WebElement selectGender = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		selectGender.click();
		WebElement clickLogin = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		clickLogin.click();
		
		WebElement selectProduct = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		
		
		int Products=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<Products;i++)
		{
			String Itemname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		
			if(Itemname.equalsIgnoreCase("Air Jordan 9 Retro"))
			{
				WebElement AddtoCartButton = driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart"));
				AddtoCartButton.click();			
			}
			
			WebElement AddtoCartLogo = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
			AddtoCartLogo.click();
			/*WebElement Title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.attributeContains(Title, "text", "Cart"));
			
			WebElement Title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.attributeContains(Title, "text", "Cart"));*/
			
			String FinalStringName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		    Assert.assertEquals(FinalStringName, "Air Jordan 9 Retro");
			
			Thread.sleep(5000);
		    
		}
	
	}

}
