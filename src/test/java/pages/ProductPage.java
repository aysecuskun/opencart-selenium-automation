package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	
     WebDriver driver;
	private By productName;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		
		 productName=By.cssSelector("div[class='col-sm'] h1");
		
	}
	
	  public String getProductName() {
	        return driver.findElement(productName).getText();
	    }
	
}
