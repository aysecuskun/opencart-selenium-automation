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
	        {"iPhone", "existing"},
	        {"XYZ123NonExistingProduct", "notExisting"},
	        {" ", "empty"}
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
        
        System.out.println("Product: [" + product + "]");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: [" + driver.getTitle() + "]");

        try {
            System.out.println("Search heading: [" +
                    driver.findElement(
                        org.openqa.selenium.By.cssSelector("#content h1")
                    ).getText() + "]");
        } catch (Exception e) {
            System.out.println("Search heading bulunamadi: "
                    + e.getClass().getSimpleName());
        }
        
        SearchPage searchpage=new SearchPage(driver);
        if (scenario.equals("existing")) {

          
            Assert.assertEquals(
                    searchpage.getProductName(),
                    product
            );

        } else if (scenario.equals("notExisting")) {


            Assert.assertEquals(
            		  searchpage.getSearchHeading(),
                      "Search - " + product
            );

          
        } else if (scenario.equals("empty")) {

        	
        	   Assert.assertEquals(
        			   searchpage.getSearchHeading(),
                       "Search -" 
               );
        }
    }
     
	}
	
