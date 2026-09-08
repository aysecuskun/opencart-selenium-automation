package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import testBase.BaseClass;

public class SearchTest extends BaseClass{
  
	@BeforeMethod
	public void setUpSearch() {

	    HomePage homepage = new HomePage(driver);

	    homepage.goToLoginPage();

	    LoginPage loginpage = new LoginPage(driver);

	    loginpage.getLogin("Deneme1@gmail.com", "Deneme1");
	    Assert.assertTrue(loginpage.isLoginSuccessful());
	
	}
	
	@Test
	public void searchProduct() {
	  

	    HomePage homepage = new HomePage(driver);
        homepage.searchProduct("HP LP3065");
        
        SearchPage searchpage=new SearchPage(driver);
        Assert.assertEquals(
                searchpage.getSearchHeading(),
                "Search - HP LP3065"
            );
        
        Assert.assertEquals(
        	    searchpage.getProductName(),
        	    "HP LP3065"
        	);
        
     
	}
	
}
