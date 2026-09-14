package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
	 
	private WebDriver driver;
	private By basketHeading;
	private By quantityInput;
	private By removeButton;
	private By emptyBasketMessage;

	public BasketPage(WebDriver driver) {
		
		this.driver=driver;
		basketHeading=By.cssSelector("[id='shopping-cart'] h1");
		quantityInput = By.name("quantity");
		removeButton = By.cssSelector("a[title='Remove']");
		
	    emptyBasketMessage =By.xpath("//p[normalize-space()='Your shopping cart is empty!']");
	}
	
	public String getBasketHeading() {
		
		return driver.findElement(basketHeading).getText();
	}
	
	public void enterQuantity(String quantity) {
	    driver.findElement(quantityInput).clear();
	    driver.findElement(quantityInput).sendKeys(quantity);
	}
	
	public int getProductQuantity() {
	    return Integer.parseInt(
	        driver.findElement(quantityInput).getAttribute("value")
	    ); 
	  
	}

	 public void removeProduct() {
	        driver.findElement(removeButton).click();
	    }
	 
	 
	 public String getEmptyBasketMessage() {
		    return driver.findElement(emptyBasketMessage).getText();
		}
	 
	
}
