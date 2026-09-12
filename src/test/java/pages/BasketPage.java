package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
	 
	private WebDriver driver;
	private By basketHeading;
	private By quantityInput;
	
	public BasketPage(WebDriver driver) {
		
		this.driver=driver;
		basketHeading=By.cssSelector("[id='shopping-cart'] h1");
		
	}
	
	public String getBasketHeading() {
		
		return driver.findElement(basketHeading).getText();
	}
	
	public int getProductQuantity() {
	    return Integer.parseInt(
	        driver.findElement(quantityInput).getAttribute("value")
	    );
	}

}
