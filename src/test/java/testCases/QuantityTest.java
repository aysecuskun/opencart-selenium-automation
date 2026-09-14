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

public class QuantityTest extends BaseClass {
	
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
	 @Test(priority=1)                                                      //sepete girilen değeri değiştirme işelmi 
	    public void verifyDifferentQuantityCanBeEntered() {
		  ProductPage productPage = new ProductPage(driver);
	        productPage.enterQuantity("7");

	        Assert.assertEquals(productPage.getQuantityValue(),"7");
	    }
	    
	  
	 
	 /*  Bu adımın başarılı olması için sepetin boş olması gerekiyor  */
	 @Test(priority=2)  
	 //ürüne ekleme yaptığımızda değişiklik sepette de aynı mı
	 public void verifyIncreasedQuantityIsAddedToBasket() {
		 
		 ProductPage productPage = new ProductPage(driver);

		 productPage.goToBasket();

		 BasketPage basketpage = new BasketPage(driver);

		 basketpage.removeProduct();

		 Assert.assertEquals(
		         basketpage.getEmptyBasketMessage(),
		         "Your shopping cart is empty!"
		 );
	    
		 HomePage homepage = new HomePage(driver);
		 homepage.searchProduct("Iphone");

		 SearchPage searchpage = new SearchPage(driver);
		 String productName = searchpage.getProductName();
		 searchpage.clickProduct(productName);

		 productPage = new ProductPage(driver);
		 productPage.enterQuantity("5");
		 productPage.addToCartButtonClick();

		 // BURADA success alert içindeki link kullanılacak
		 productPage.clickShoppingCartLink();

		 int basketQuantity = basketpage.getProductQuantity();

		 Assert.assertEquals(basketQuantity, 5);
	 }
	
}