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
		
		@Test(priority = 1)                  //Ürün detayına geldik ve doğru ürün olduğunu doğruladık

		public void verifyProductDetailPage() { 
			HomePage homepage = new HomePage(driver); 
			homepage.searchProduct("Iphone"); 
			SearchPage searchpage = new SearchPage(driver);
			String productName = searchpage.getProductName();
			searchpage.clickProduct(productName); 
		    ProductPage productPage = new ProductPage(driver); 
		    Assert.assertEquals( productPage.getProductName(), productName ); 
		    
		}

		
		  @Test(priority = 2)                //Add to Cart → popup çıktı mı?Linke tıklandı mı 

		    public void verifyAddToCartSuccessMessage() {

		        HomePage homepage = new HomePage(driver);
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
		    }
		  
		    @Test(priority=3)                  //Add to Cart → popup → Shopping Cart linkine tıkla → BasketPage'e geldik mi?
		    public void verifyShoppingCartNavigation() {

		        HomePage homepage = new HomePage(driver);
		        homepage.searchProduct("Iphone");

		        SearchPage searchpage = new SearchPage(driver);

		        String productName = searchpage.getProductName();//aranılan ürün ismi

		        searchpage.clickProduct(productName);

		        ProductPage productPage = new ProductPage(driver);

		        productPage.addToCartButtonClick();

		        Assert.assertTrue(
		                productPage.getAddToCartAlertMessage()
		                        .contains("Success: You have added")
		        );

		        productPage.clickShoppingCartLink();

		        BasketPage basketPage = new BasketPage(driver);

		        Assert.assertTrue(
		                basketPage.getBasketHeading().startsWith("Shopping Cart")
		        );
		    }
		    
		    @Test(priority=4)            //Ürün detay sayfasında ki ürünün fiyatı dolu mu boş mu? 
		    public void verifyProductPrice() {

		        HomePage homepage = new HomePage(driver);
		        homepage.searchProduct("Iphone");

		        SearchPage searchpage = new SearchPage(driver);

		        String productName = searchpage.getProductName();

		        searchpage.clickProduct(productName);

		        ProductPage productPage = new ProductPage(driver);

		        Assert.assertFalse(
		            productPage.getProductPrice().isEmpty()
		        );
		    }
		    
		    @Test(priority=5)          // Ürünün görseli görünüyor mu?
		    public void verifyProductImageDisplayed() {

		        HomePage homepage = new HomePage(driver);
		        homepage.searchProduct("Iphone");

		        SearchPage searchpage = new SearchPage(driver);

		        String productName = searchpage.getProductName();

		        searchpage.clickProduct(productName);

		        ProductPage productPage = new ProductPage(driver);

		        Assert.assertTrue(
		            productPage.isProductImageDisplayed()
		        );
		    }
	}



