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

	    loginpage.getLogin("Test@gmail.com", "Test123");
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
	

        @Test(priority = 4)
        public void verifyFirstNameValidation() {

            CheckoutPage checkout = new CheckoutPage(driver);

            checkout.enterLastName("Test");
            checkout.enterAddress1("Test Address");
            checkout.enterCity("Istanbul");
            checkout.enterPostCode("34000");
            checkout.selectCountry("United Kingdom");
            checkout.selectRegionState("Bristol");

            checkout.clickShippingAddressContinue();

            Assert.assertEquals(
                checkout.getFirstNameValidation(),
                "First Name must be between 1 and 32 characters!"
            );
        }
        
        
        @Test(priority = 5)
        public void verifyLastNameValidation() {

            CheckoutPage checkout = new CheckoutPage(driver);

            checkout.enterFirstName("Test");
            checkout.enterAddress1("Test Address");
            checkout.enterCity("Istanbul");
            checkout.enterPostCode("34000");
            checkout.selectCountry("Turkmenistan");
            checkout.selectRegionState("Ahal Welayaty");

            checkout.clickShippingAddressContinue();
            
            Assert.assertEquals(
                checkout.getLastNameValidation(),
                "Last Name must be between 1 and 32 characters!"
            );
        }
       
        @Test(priority = 6)
        public void verifyAddress1Validation() {

            CheckoutPage checkout = new CheckoutPage(driver);
            checkout.selectNewAddress();
            checkout.enterFirstName("Test");
            checkout.enterLastName("User");
            checkout.enterCity("Istanbul");
            checkout.enterPostCode("34000");
            checkout.selectCountry("Switzerland");
            checkout.selectRegionState("Solothurn");

            checkout.clickShippingAddressContinue();

            Assert.assertEquals(
                checkout.getAddress1Validation(),
                "Address 1 must be between 3 and 128 characters!"
            );
        }
        
        @Test(priority = 7)
        public void verifyCityValidation() {

            CheckoutPage checkout = new CheckoutPage(driver);

            checkout.enterFirstName("Test");
            checkout.enterLastName("User");
            checkout.enterAddress1("Test Address");
            checkout.enterPostCode("34000");
            checkout.selectCountry("South Korea");
            checkout.selectRegionState("Busan-gwangyeoksi");

            checkout.clickShippingAddressContinue();

            Assert.assertEquals(
                checkout.getCityValidation(),
                "City must be between 2 and 128 characters!"
            );
        }
        
        @Test(priority = 8)
        public void verifyPostCodeValidation() {

            CheckoutPage checkout = new CheckoutPage(driver);

            checkout.enterFirstName("Test");
            checkout.enterLastName("User");
            checkout.enterAddress1("Test Address");
            checkout.enterCity("Istanbul");
          
            checkout.selectCountry("United Kingdom");
            checkout.selectRegionState("Bristol");

            checkout.clickShippingAddressContinue();

            Assert.assertEquals(
                checkout.getPostCodeValidation(),
                "Postcode must be between 2 and 10 characters!"
            );
        }
        
        @Test(priority = 9)
        public void verifyRegionStateValidation() {

            CheckoutPage checkout = new CheckoutPage(driver);

            checkout.enterFirstName("Test");
            checkout.enterLastName("User");
            checkout.enterAddress1("Test Address");
            checkout.enterCity("Istanbul");
            checkout.enterPostCode("34000");
            checkout.selectCountry("United Kingdom");

            checkout.clickShippingAddressContinue();

            Assert.assertEquals(
                checkout.getRegionStateValidation(),
                "Please select a region / state!"
            );
        }
     
        @Test(priority = 10)
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
        
        @Test(priority = 11)
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
        
        @Test(priority = 12)
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
	
	
	
