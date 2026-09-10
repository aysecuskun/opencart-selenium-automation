package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	 WebDriver driver;

	    // Locators
	  
	    //private By productImage;
	    private By noProductMessage;
	    private By searchHeading;  
	    private By productImage = By.cssSelector("div.product-thumb img");

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	      
	       // productImage = By.cssSelector("img[title='HP LP3065']");//sepette olan ürünün ismi
	        noProductMessage = By.xpath("//div[@id='content']//p");   // ürün girildikten sonra aranılan değerin olmadığını veren locator 
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
	    
	    public boolean isProductDisplayed(String productName) {
	        
	        By product = By.xpath("//div[contains(@class,'product-thumb')]//img[contains(@alt,'" + productName + "')]");

	        return driver.findElements(product).size() > 0;
	    }
	 
	    public By productLink (String productName) {
	    	  return By.xpath(
	    		        "//div[contains(@class,'product-thumb')]//a[img[@alt='" + productName + "']]"
	    		    );
	    }
	    
	    public void clickProduct(String productName) {

	    	WebElement product = driver.findElement(productLink(productName));

	        new Actions(driver)
	                .moveToElement(product)
	                .click()
	                .perform();
	    }
}
