package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import testBase.BaseClass;

public class CaseInsensitiveSearchTest extends BaseClass {
	
	@DataProvider(name = "caseData")
	public Object[][] caseData() {
	    return new Object[][] {
	        {"HP LP3065"},
	        {"hp lp3065"},
	        {"Hp Lp3065"},
	        {"hP lP3065"}
	    };
	}
	
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
	@Test(dataProvider = "caseData")
	public void searchWithDifferentCases(String product) {

		  HomePage homepage = new HomePage(driver);
	        SearchPage searchpage = new SearchPage(driver);

	        homepage.searchProduct(product);

	        Assert.assertEquals(
	                searchpage.getProductName(),
	                "HP LP3065"
	        );
	}
	

}
