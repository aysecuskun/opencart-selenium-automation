package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasketPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;
import pages.ProductPage;
import pages.SearchPage;
import testBase.BaseClass;

public class SuccessOrderTest extends BaseClass{
	@BeforeMethod
	public void setUpSearch() {
		
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
	    HomePage homepage = new HomePage(driver);

	    homepage.goToLoginPage();

	    LoginPage loginpage = new LoginPage(driver);

	    loginpage.getLogin("Universe1@gmail.com", "universe");
	    Assert.assertTrue(loginpage.isLoginSuccessful());
	
	    homepage = new HomePage(driver); 
		homepage.searchProduct("Iphone"); 
		SearchPage searchpage = new SearchPage(driver);
		
		String productName = searchpage.getProductName();
		searchpage.clickProduct(productName); 
		
		ProductPage productPage = new ProductPage(driver);
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("TITLE: " + driver.getTitle());
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
     public void verifyShippingMethodSelection() throws InterruptedException {  

         CheckoutPage checkout = new CheckoutPage(driver);
         checkout.selectExistingAdddress("Test User, Test Address, Istanbul, Bristol, United Kingdom");
         Assert.assertEquals(
                 checkout.getShippingAddressSuccessAlertMessage(),
                 "Success: You have changed shipping address!"
             );
         Thread.sleep(5000);
         checkout.clickShippingMethodChoose();
         checkout.clickShippingMethodContinue();
         Assert.assertEquals(
                 checkout.getShippingMethodSuccessAlertMessage(),
                 "Success: You have changed shipping method!"
             );
         Thread.sleep(5000);
         checkout.clickPaymentMethodChoose();
         checkout.clickPaymentMethodContinue();
	     Assert.assertEquals(
	         checkout.getPaymentMethodSuccessAlertMessage(),
	         "Success: You have changed payment method!"
	     );
	     Thread.sleep(5000);
	     checkout.clickConfirmButton();
	     OrderPage orderpage=new OrderPage(driver);
	     Assert.assertEquals(orderpage.getMessage(), "Your order has been placed!");
	     Thread.sleep(5000);
	     
     }
	
}
