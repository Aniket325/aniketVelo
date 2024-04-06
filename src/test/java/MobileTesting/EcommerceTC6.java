package MobileTesting;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EcommerceTC6 extends BaseTest{

	@Test
	public void FinalOperation() throws InterruptedException 
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
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
       
		
		Thread.sleep(2000);
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
		
		Thread.sleep(3000);
		
		WebElement Hold = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(Hold);
		WebElement closeButton = driver.findElement(By.id("android:id/button1"));
		closeButton.click();
		
		WebElement CheckBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
		CheckBox.click();
		WebElement FinalClick = driver.findElement(AppiumBy.className("android.widget.Button"));
		FinalClick.click();
		Thread.sleep(6000);
		
		
		
		Set<String> contexts=driver.getContextHandles();
		for(String ContextName:contexts)
		{
			System.out.println(ContextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");	
		Thread.sleep(8000);
		WebElement SearchOnGoogle = driver.findElement(By.xpath("//*[@name='q']"));
		SearchOnGoogle.sendKeys("Virat");
		SearchOnGoogle.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.context("NATIVE_APP");
		Thread.sleep(5000);
	}	
}
