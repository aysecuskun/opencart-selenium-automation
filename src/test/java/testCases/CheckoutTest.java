package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasketPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import testBase.BaseClass;

public class CheckoutTest extends BaseClass{
	
	@BeforeMethod
	public void setUpSearch() {
		
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
	    HomePage homepage = new HomePage(driver);

	    homepage.goToLoginPage();

	    LoginPage loginpage = new LoginPage(driver);

	    loginpage.getLogin("Deneme1@gmail.com", "Deneme1");
	    Assert.assertTrue(loginpage.isLoginSuccessful());
	
	    homepage = new HomePage(driver); 
		homepage.searchProduct("Iphone"); 
		SearchPage searchpage = new SearchPage(driver);
		
		String productName = searchpage.getProductName();
		searchpage.clickProduct(productName); 
		
		ProductPage productPage = new ProductPage(driver);

        productPage.addToCartButtonClick();

        Assert.assertTrue(
            productPage.getAddToCartAlertMessage()
                .contains("Success: You have added")
        );

        productPage.clickShoppingCartLink();

        BasketPage basketPage = new BasketPage(driver);

        basketPage.clickCheckout();
	 
	}
	
	@Test
	public void pageCheckout() {
		
		CheckoutPage checkout=new CheckoutPage(driver);
        System.out.println(checkout.getCheckoutHeading());
        checkout.clickShippingAddressContinue();

     }
	
}
