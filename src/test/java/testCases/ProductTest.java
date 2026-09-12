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

	public class ProductTest extends BaseClass {
		
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
		
		@Test
		public void goToProductDetailPage() {

		    HomePage homepage = new HomePage(driver);
		    homepage.searchProduct("Iphone");

		    SearchPage searchpage = new SearchPage(driver);

		    String productName = searchpage.getProductName();

		    searchpage.clickProduct(productName);

		    ProductPage productDetailPage = new ProductPage(driver);

		    Assert.assertEquals(
		        productDetailPage.getProductName(),
		        productName
		    );
		    
		    productDetailPage.addToCartButtonClick();

		    Assert.assertTrue(
		        productDetailPage.getAddToCartAlertMessage()
		            .contains("Success: You have added")
		    );
		    
		 
		    productDetailPage.clickShoppingCartLink();

		    BasketPage basketPage = new BasketPage(driver);

		    Assert.assertEquals(
		        basketPage.getBasketHeading(),
		        "Shopping Cart"
		    );
		}

	}



