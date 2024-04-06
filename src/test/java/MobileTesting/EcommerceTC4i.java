package MobileTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC4i extends BaseTest {

	@Test
	
	public void ProductSelect() throws InterruptedException 
	{
		WebElement ClickOnDropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		ClickOnDropdown.click();
		WebElement selectCountry = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"));"));
		selectCountry.click();
		WebElement Entername = driver.findElement(By.id( "com.androidsample.generalstore:id/nameField"));
		Entername.sendKeys("Shobha");
		WebElement selectGender = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		selectGender.click();
		WebElement clickLogin = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		clickLogin.click();
		
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		 
		WebElement CartButton = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		CartButton.click();
		
		WebElement Title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(Title, "text", "Cart"));
		
		List<WebElement> PriceString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int Number=PriceString.size();
		double sum=0;
		for(int i=0;i<Number;i++)
		{
			String value = PriceString.get(i).getText();
			double price=Double.parseDouble(value.substring(1));
			sum=sum+price;
		    
		
		}
		System.out.println("$"+sum);
		
		String FinalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double Final = Double.parseDouble(FinalPrice.substring(1));
		Assert.assertEquals(sum, Final);
		
		Thread.sleep(3000);
		
       }
}
