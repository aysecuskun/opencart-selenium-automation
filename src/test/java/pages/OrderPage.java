package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

	private WebDriver driver;
    private By confirmHeadingMessage;
	
	public OrderPage(WebDriver driver) {
		
		this.driver=driver;
		confirmHeadingMessage=By.xpath("//h1[normalize-space()='Your order has been placed!']");
	}
	
	public String getMessage() {
		
		return driver.findElement(confirmHeadingMessage).getText();
	}
	
	
}
