package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import testBase.BaseClass;

public class PartialSearchTest extends BaseClass {

	@BeforeMethod
	public void setUpSearch() {
		
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
	    HomePage homepage = new HomePage(driver);

	    homepage.goToLoginPage();

	    LoginPage loginpage = new LoginPage(driver);

	    loginpage.getLogin("Deneme1@gmail.com", "Deneme1");
	    Assert.assertTrue(loginpage.isLoginSuccessful());
	
	}
	
	@Test
	public void searchWithPartialProductName() {

	    HomePage homepage = new HomePage(driver);
	    homepage.searchProduct("HP");

	    SearchPage searchpage = new SearchPage(driver);

	    Assert.assertTrue(
	        searchpage.isProductDisplayed("HP LP3065")
	    );
	}
	
}
