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
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		
		 productName=By.cssSelector("div[class='col-sm'] h1");
		 quantityCount=By.cssSelector("#input-quantity");
		 addToCartButton=By.cssSelector("#button-cart");
		 addToCartAlert = By.cssSelector("#alert .alert-success");
		 shoppingCartLink=By.cssSelector("#alert .alert-success a[href*='checkout/cart']");
	}
	
	  public String getProductName() {
	        return driver.findElement(productName).getText();
	    }
	  
	  public String getQuantityValue() {
		  
		  return driver.findElement(quantityCount).getAttribute("value");
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
	  
	
}
