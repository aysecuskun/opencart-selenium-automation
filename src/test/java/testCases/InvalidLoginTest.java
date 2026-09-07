package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.BaseClass;

public class InvalidLoginTest extends BaseClass {
	@BeforeMethod
	public void LoginClick() {
		  
		HomePage homepage=new HomePage(driver);
		homepage.goToLoginPage();//Dropdown da yer alan login butonuna tıklar.
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencart/upload/index.php?route=account/login&language=en-gb");//Login sayfasının açıldığını doğrular 
		
}
	 @DataProvider(name = "invalidLoginData")
	    
	  public Object[][] invalidLoginData() {
	        return new Object[][] {
	            {"Deneme1@gmail.com", "Deneme", "invalidPassword"},
	            {"yanlis@gmail.com", "Deneme1", "invalidEmail"},
	            {"Deneme1@gmail.com", "", "emptyPassword"},
	            {"", "Deneme1", "emptyEmail"}
	        };
	    }
	 
	 @Test(dataProvider = "invalidLoginData")
	    public void invalidLoginTest(String email, String password, String scenario) {

	        LoginPage loginpage = new LoginPage(driver);

	        loginpage.getLogin(email, password);
	            Assert.assertTrue(loginpage.isLoginErrorDisplayed());//Alert mesajı görünür mü( Locator )
	            Assert.assertEquals(loginpage.getLoginErrorMessage(),"Warning: No match for E-Mail Address and/or Password."); // Alert mesajının içeriği 
	            
	            

	       

	       
}
	 }
