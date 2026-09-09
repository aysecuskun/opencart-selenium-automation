package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
public class BaseClass {
	
	public WebDriver driver;
	public String baseURL="http://localhost/opencart/upload/index.php";
	@BeforeTest
	public void setup() {


	    ChromeOptions options = new ChromeOptions();

	    Map<String, Object> prefs = new HashMap<>();

	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);
	    prefs.put("password_manager_enabled", false);

	    options.setExperimentalOption("prefs", prefs);

	    driver = new ChromeDriver(options);

	    driver.manage().deleteAllCookies();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    driver.get(baseURL);

	    driver.manage().window().maximize();
	}
	
	@AfterTest
	public void Deartown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}

}
