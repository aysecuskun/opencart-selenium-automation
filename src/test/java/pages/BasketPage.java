package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
	 
	private WebDriver driver;
	private By basketHeading;
	private By quantityInput;
	private By removeButton;
	private By emptyBasketMessage;
	private By productName;
	private By productPrice;
	private By totalPrice ;
	private By checkoutButton;
	public BasketPage(WebDriver driver) {
		
		this.driver=driver;
		basketHeading=By.cssSelector("[id='shopping-cart'] h1");
		quantityInput = By.name("quantity");
		removeButton = By.cssSelector("a[title='Remove']");
		
	    emptyBasketMessage =By.xpath("//p[normalize-space()='Your shopping cart is empty!']");
	    productName= By.cssSelector("td[class='text-start text-wrap'] a");
	    productPrice = By.xpath("//th[normalize-space()='Unit Price']/ancestor::table//tbody//tr//td[4]");
	    totalPrice =By.xpath("//tfoot[@id='checkout-total']//tr[last()]/td[2]");
	   checkoutButton = By.cssSelector("a[href*='checkout/checkout']");
	}
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
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
	 
	 public String getProductPrice() {
		    return driver.findElement(productPrice).getText();
		}
	
	 public String getTotalPrice() {
		    return driver.findElement(totalPrice).getText();
		}
	 
	 public void clickCheckout() {
		    driver.findElement(checkoutButton).click();
		}
}
