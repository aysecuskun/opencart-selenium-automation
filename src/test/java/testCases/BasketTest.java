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

public class BasketTest extends BaseClass{
	
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
	 
	}
	
	@Test(priority=1)
	public void verifyProductNameInBasket() {      //aranılan ürün ile sepette ki ürün adının doğru olması 


	        ProductPage productPage = new ProductPage(driver);
	        String productName = productPage.getProductName();
	        productPage.addToCartButtonClick();
	        Assert.assertTrue(
	            productPage.getAddToCartAlertMessage()
	                .contains("Success: You have added")
	        );

	        productPage.clickShoppingCartLink();

	        BasketPage basketPage = new BasketPage(driver);

	        Assert.assertEquals(
	            basketPage.getProductName(),
	            productName
	        );
	        
	        System.out.println(productName);
	}
	
	 @Test(priority=2)         //sepette ki toplam tutarın doğru olduğunu bulan kod               
	 public void verifyTotalPriceInBasket() {

	     ProductPage productPage = new ProductPage(driver);

	     productPage.addToCartButtonClick();

	     Assert.assertTrue(
	         productPage.getAddToCartAlertMessage()
	             .contains("Success: You have added")
	     );

	     productPage.clickShoppingCartLink();

	     BasketPage basketPage = new BasketPage(driver);

	     String productPrice = basketPage.getProductPrice();

	     int quantity = basketPage.getProductQuantity();

	     String totalPrice = basketPage.getTotalPrice();

	     double price = Double.parseDouble(productPrice.replace("$", ""));

	     double actualTotal = Double.parseDouble(totalPrice.replace("$", ""));

	     double expectedTotal = price * quantity;

	     Assert.assertEquals(actualTotal,expectedTotal, 0.01);
	     
		 System.out.println("sum total" +totalPrice);
	 }
	 
	 @Test(priority=3)
	 public void clickCheckoutButton() {
		 ProductPage productPage = new ProductPage(driver);

	     productPage.addToCartButtonClick();

	     Assert.assertTrue(
	         productPage.getAddToCartAlertMessage()
	             .contains("Success: You have added")
	     );

	     productPage.clickShoppingCartLink();

	     BasketPage basketPage = new BasketPage(driver);
	     basketPage.clickCheckout();
	     
	     CheckoutPage checkoutpage=new CheckoutPage(driver);
	     
	     
	     Assert.assertEquals(checkoutpage.getCheckoutHeading(), "Checkout");
		 
	 }

}
