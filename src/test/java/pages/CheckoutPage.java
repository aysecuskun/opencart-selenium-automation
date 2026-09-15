package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	private By checkoutHeading;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver=driver;
		checkoutHeading=By.xpath("//h1[normalize-space()='Checkout']");
	}
		
		public String getCheckoutHeading() {
			
			return driver.findElement(checkoutHeading).getText();
			
		}
		
		
		
		
	

}
