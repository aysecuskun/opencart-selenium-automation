package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import testBase.BaseClass;

public class SpecialCharacters extends BaseClass{

	@DataProvider(name = "specialCharacterData")
	public Object[][] specialCharacterData() {
	    return new Object[][] {
	        {"HP@LP3065"},
	        {"HP#LP3065"},
	        {"HP$LP3065"}
	        
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
	
	@Test(dataProvider = "specialCharacterData")
	public void searchWithSpecialCharacters(String searchText) {

	    HomePage homepage = new HomePage(driver);
	    SearchPage searchpage = new SearchPage(driver);

	    homepage.searchProduct(searchText);

	    Assert.assertEquals(
	        searchpage.getNoProductMessage(),
	        "There is no product that matches the search criteria."
	    );
	}

}
