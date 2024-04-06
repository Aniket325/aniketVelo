package MobileTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserBaseTest {
	public AndroidDriver driver;
	@BeforeClass
public void ConfigurationAppium() throws MalformedURLException, InterruptedException
	{
		//chatgptLogger logger = Logger.getLogger(new String("AppiumBasics"));
				//AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\anike\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				//.withIPAddress("127.0.0.1")
				//.usingPort(4723)
				//.build();
				//service.start();
				
		        UiAutomator2Options options=new UiAutomator2Options();
				options.setDeviceName("AniketePhone");
				options.setChromedriverExecutable("C:\\\\Users\\\\anike\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			    options.setCapability("browserName", "Chrome");
				
			    driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		             // Thread.sleep(3000);
				
	}
public void LongPressAction(WebElement ele)
{
	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
    		ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
}
@AfterClass
	public void TearDown()
	{
		driver.quit();
		//service.stop();
	
}
}
