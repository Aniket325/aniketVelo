package MobileTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC4ii extends BaseTest {
	@Test
	
	public void ProductSelect() throws InterruptedException 
	{
		WebElement ClickOnDropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		ClickOnDropdown.click();
		WebElement selectCountry = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Australia\"));"));
		selectCountry.click();
		WebElement Entername = driver.findElement(By.id( "com.androidsample.generalstore:id/nameField"));
		Entername.sendKeys("Shobha");
		WebElement selectGender = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		selectGender.click();
		WebElement clickLogin = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		clickLogin.click();
		//It works only when we are using Xpath
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        /*It will not work for id, we have to chane the index then
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		*/
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		List<WebElement> ProductPrices = driver.findElements(By.id( "com.androidsample.generalstore:id/productPrice"));
		int Prices = ProductPrices.size();
		double addition=0;
		for(int i=0;i<Prices;i++)
		{
			
			String StringPrices=ProductPrices.get(i).getText();
			double MRP=Double.parseDouble(StringPrices.substring(1));
			addition=addition+MRP;
					
			
		}
		
		System.out.println(addition);
		
		String FinalStringPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double FinalMRP=Double.parseDouble(FinalStringPrice.substring(1));
		Assert.assertEquals(FinalMRP, addition);
		
		Thread.sleep(5000);
}
}