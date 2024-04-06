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

public class EcommerceTC4 extends BaseTest {
	@Test
	public void ProductSelect() throws InterruptedException 
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"));")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja");
	    driver.hideKeyboard();
	    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	  
	   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   // After clicking 1st 'add to cart' then it will become'added to cart'
	   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   
	   //driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]"))
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
	   WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));;
	
	   List<WebElement> Productprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	  int count= Productprices.size();
	  double finalprice = 0;
	  for(int i=0;i<count;i++)
	  {
		  String amountstring=Productprices.get(i).getText();
		  Double price=Double.parseDouble((amountstring.substring(1)));
		  finalprice=finalprice+price;
	  }
	  String finalString= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	  Double finalamount=Double.parseDouble(finalString.substring(1));
	  Assert.assertEquals(finalprice,finalamount);
	  
	}
	
}
