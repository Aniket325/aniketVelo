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

public class EcommerceTC6i extends BaseTest{

	@Test
	public void HybridApp() throws InterruptedException 
	{
		//LoginPage
		WebElement ClickOnDropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		ClickOnDropdown.click();
		
		WebElement selectNation = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Bahamas\"));"));
		selectNation.click();
		
		WebElement Username = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		Username.sendKeys("shree");
		
		WebElement SelectGender = driver.findElement(By.xpath("//android.widget.RadioButton[2]"));
		SelectGender.click();
		  
		WebElement SubmitButton = driver.findElement(By.xpath("//android.widget.Button[@index='6']"));
		SubmitButton.click();
		
		//ProductPage
		WebElement FirstProduct = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0);
		FirstProduct.click();
		
		WebElement SecondProduct = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1);
		SecondProduct.click();
	
		WebElement ClickOnCart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		ClickOnCart.click();
		  Thread.sleep(5000);
		//CartPAge
		WebElement TitleofPage = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		String Title = TitleofPage.getText();
		Assert.assertEquals(Title, "Cart");
		
		 List<WebElement> PriceTag = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		 int items = PriceTag.size();
		 double sum=0;
		 for(int i=0;i<items;i++)
		 {
			 String StringPrices=PriceTag.get(i).getText();
			 double Price = Double.parseDouble(StringPrices.substring(1));
			 sum=sum+Price;
			 
		 }
		 
		 System.out.println(sum);
		 
		 WebElement FinalValue = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		 String StringValue=FinalValue.getText();
		 double Value=Double.parseDouble(StringValue.substring(1));
		 Assert.assertEquals(sum, Value);
		 
		 WebElement Hold = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		 LongPressAction(Hold);
		 
		 WebElement CloseThePopup = driver.findElement(AppiumBy.className(	"android.widget.Button"));
		 CloseThePopup.click();
		 
		 WebElement CheckBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
		 CheckBox.click();
		 
		 WebElement VisitToWebsite = driver.findElement(By.id(	"com.androidsample.generalstore:id/btnProceed"));
		 VisitToWebsite.click();
		 
		 Thread.sleep(9000);
		 
		 //ToHandleHybridApp
		 Set<String> Contexts = driver.getContextHandles();
	     for(String ContextsNames:Contexts)
	     {
	    	 System.out.println(ContextsNames);
	     }
	     driver.context("WEBVIEW_com.androidsample.generalstore");
	     
	     //BeforeStartoperationabove process is required
	     WebElement GoogleSearch = driver.findElement(By.xpath("//*[@name='q']"));
	     GoogleSearch.sendKeys("MS Dhoni");
	     GoogleSearch.sendKeys(Keys.ENTER);
	     
	     driver.pressKey(new KeyEvent(AndroidKey.BACK));
	     
		  
	     Thread.sleep(4000);
		
		
		
		
		
	}	
}
