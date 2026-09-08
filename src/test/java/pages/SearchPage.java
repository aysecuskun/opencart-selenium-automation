package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	 WebDriver driver;

	    // Locators
	  
	    private By productImage;
	    private By noProductMessage;
	    private By searchHeading;  

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	      
	        productImage = By.cssSelector("img[title='HP LP3065']");//sepette olan ürünün ismi
	        noProductMessage = By.cssSelector("#content p");   //sepette ürün yoksa mesajı 
	    	searchHeading=By.cssSelector("div[id='content'] h1");

	    }

	    // Methods
	    public String getProductName() {
	        return driver.findElement(productImage).getAttribute("alt");
	    }
	  
      
	    public String getNoProductMessage() {
	        return driver.findElement(noProductMessage).getText();
	    }
	    
	    
	    public String getSearchHeading() {
	    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    	    return wait.until(
	    	        ExpectedConditions.visibilityOfElementLocated(searchHeading)
	    	    ).getText();
	    }
	 

}
