package MobileTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest2 extends BrowserBaseTest {

	@Test
	
	public void RahulShettyApp() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//*[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		String ProductText = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Assert.assertEquals(ProductText, "Devops");
		Thread.sleep(4000);
		
	}
	
	
}
