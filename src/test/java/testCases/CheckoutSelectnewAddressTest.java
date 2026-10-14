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

public class CheckoutSelectnewAddressTest extends BaseClass {

	
	@BeforeMethod
	public void setUpSearch() {
		
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
	    HomePage homepage = new HomePage(driver);

	    homepage.goToLoginPage();

	    LoginPage loginpage = new LoginPage(driver);

	    loginpage.getLogin("Test@gmail.com", "Test123");
	    Assert.assertTrue(loginpage.isLoginSuccessful());
	 
	    homepage = new HomePage(driver); 
	    homepage.clickCheckoutButton();
	    
	     CheckoutPage checkoutpage=new CheckoutPage(driver);
	     Assert.assertEquals(checkoutpage.getCheckoutHeading(), "Checkout");
	 
	}
	
	@Test(priority = 1)
    public void verifyFirstNameMinimumLength() {

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.selectNewAddress();

        checkout.enterFirstName("A");
        checkout.enterLastName("Test");
        checkout.enterAddress1("Test Address");
        checkout.enterCity("Istanbul");
        checkout.enterPostCode("34000");
        checkout.selectCountry("United Kingdom");
        checkout.selectRegionState("Bristol");

        checkout.clickShippingAddressContinue();

        Assert.assertFalse(
            checkout.isFirstNameValidationDisplayed()
        );
        
    }
    
    @Test(priority = 2)
    public void verifyAddress1MaximumLengthExceeded() {

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.selectNewAddress();

        checkout.enterFirstName("A");
        checkout.enterLastName("Test");

        String address = "Test Adres testtettstststtststtststststssttstsstttttttttttttttttttttttttttttttttttttttttttttttttttt777777777777777777777777777777777777777777777777777777777777777777";
       
        checkout.enterAddress1(address);

        checkout.enterCity("Istanbul");
        checkout.enterPostCode("34000");
        checkout.selectCountry("United Kingdom");
        checkout.selectRegionState("Bristol");

        checkout.clickShippingAddressContinue();

        Assert.assertEquals(
                checkout.getAddress1Validation(),
                "Address 1 must be between 3 and 128 characters!"
            );
    }
    
    @Test(priority = 3)
    public void verifyShippingAddressSuccessfullySubmitted() {

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.selectNewAddress();

        checkout.enterFirstName("A");
        checkout.enterLastName("Test");
        checkout.enterAddress1("Test Address");
        checkout.enterCity("Istanbul");
        checkout.enterPostCode("34000");
        checkout.selectCountry("South Korea");
        checkout.selectRegionState("Busan-gwangyeoksi");

        checkout.clickShippingAddressContinue();

        Assert.assertEquals(
            checkout.getShippingAddressSuccessAlertMessage(),
            "Success: You have changed shipping address!"
        );
    }
    
}
