package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import testBase.BaseClass;

public class SearchTest extends BaseClass{
    
	@DataProvider(name = "searchData")
	public Object[][] searchData() {
	    return new Object[][] {
	        {"HP LP3065", "existing"},
	        {"XYZ123NonExistingProduct", "notExisting"},
	        {"", "empty"}
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
	
	@Test(dataProvider = "searchData")
	public void searchProduct(String product, String scenario) {
	  

	    HomePage homepage = new HomePage(driver);
        homepage.searchProduct(product);
        
        SearchPage searchpage=new SearchPage(driver);
        if (scenario.equals("existing")) {

            Assert.assertEquals(
                    searchpage.getSearchHeading(),
                    "Search - " + product
            );

            Assert.assertEquals(
                    searchpage.getProductName(),
                    product
            );

        } else if (scenario.equals("notExisting")) {

            Assert.assertEquals(
                    searchpage.getSearchHeading(),
                    "Search - " + product
            );

            Assert.assertEquals(
                    searchpage.getNoProductMessage(),
                    "There is no product that matches the search criteria."
            );

        } else if (scenario.equals("empty")) {

            Assert.assertEquals(
                    searchpage.getNoProductMessage(),
                    "There is no product that matches the search criteria."
            );
        }
    }
     
	}
	
