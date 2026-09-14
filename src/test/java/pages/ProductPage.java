package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	
    private WebDriver driver;
	private By productName;
	private By quantityCount;
	private By addToCartButton;
	private By addToCartAlert;
	private By shoppingCartLink;
	private By productPrice;
	private By productImage;
	private By basketLink;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		
		 productName=By.cssSelector("div[class='col-sm'] h1");
		 quantityCount=By.cssSelector("#input-quantity");
		 addToCartButton=By.cssSelector("#button-cart");
		 addToCartAlert = By.cssSelector("#alert .alert-success");
		 shoppingCartLink=By.cssSelector("#alert .alert-success a[href*='checkout/cart']");
		 productPrice = By.cssSelector("ul[class='list-unstyled'] span[class='price-new']");
		 productImage=By.cssSelector("img.img-thumbnail.mb-3");
		 basketLink = By.cssSelector("a[title='Shopping Cart']");
	}
	
	  public String getProductName() {
	        return driver.findElement(productName).getText();
	    }
	  
	  public String getQuantityValue() {
		  
		  return driver.findElement(quantityCount).getAttribute("value");
	  }
	  
	  public void enterQuantity(String quantity) {
		    driver.findElement(quantityCount).clear();
		    driver.findElement(quantityCount).sendKeys(quantity);
		}
	  
	  public void addToCartButtonClick() {
		  
		  driver.findElement(addToCartButton).click();
	  }
	  
	  public String getAddToCartAlertMessage() {
		    return driver.findElement(addToCartAlert).getText();
		}
	  
	  public void clickShoppingCartLink() {
		    driver.findElement(shoppingCartLink).click();
		}
	  
	  public String getProductPrice() {
		    return driver.findElement(productPrice).getText();
		}
	  
	  public boolean isProductImageDisplayed() {
		    return driver.findElement(productImage).isDisplayed();
		}
	  public void goToBasket() {
		    driver.findElement(basketLink).click();
		}

		
}
