package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	@Test
	public void LoginClick() {
		  
		HomePage homepage=new HomePage(driver);
		homepage.goToLoginPage();//Dropdown da yer alan login butonuna tıklar.
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencart/upload/index.php?route=account/login&language=en-gb");//Login sayfasının açıldığını doğrular 
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.getLogin("Deneme1@gmail.com", "Deneme1");
		Assert.assertTrue(loginpage.isLoginSuccessful());
		
		
	}

}
