package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import testBase.BaseClass;

public class BasketPriceTest extends BaseClass {
	
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

		 productPage.goToBasket();

		 BasketPage basketpage = new BasketPage(driver);

		 basketpage.removeProduct();

		 Assert.assertEquals(
		         basketpage.getEmptyBasketMessage(),
		         "Your shopping cart is empty!"
		 );
		 
		 homepage = new HomePage(driver);
		 homepage.searchProduct("Iphone");

		 searchpage = new SearchPage(driver);
		 productName = searchpage.getProductName();
		 searchpage.clickProduct(productName);
	}
	
	/*add to cart sonrası sepette olan ürün fiyatının önceden eklenen ürün fiyatıyla aynı olup olmadığını test eden senaryo */

		 @Test                         
		 public void verifyProductPriceInBasket() {             // 
		     ProductPage productPage = new ProductPage(driver);

		     String productPrice = productPage.getProductPrice();

		     productPage.addToCartButtonClick();

		     Assert.assertTrue(
		         productPage.getAddToCartAlertMessage()
		             .contains("Success: You have added")
		     );

		     productPage.clickShoppingCartLink();

		     BasketPage basketPage = new BasketPage(driver);

		     Assert.assertEquals(
		         basketPage.getProductPrice(),
		         productPrice
		     );
		     
		     System.out.println(productPrice);
		     
		 }
		 
}
	
	

