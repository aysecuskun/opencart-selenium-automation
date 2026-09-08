package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	    private WebDriver driver;
	    private By myAccount;
	    private By loginLink;
	    private By searchBox;
	    private By searchButton;
	    private By homeLink;
	    
	   
        public HomePage(WebDriver driver) {
		this.driver=driver;
		
		myAccount=By.xpath("//span[normalize-space()='My Account']");
		loginLink=By.xpath("//a[normalize-space()='Login']");
		searchBox = By.name("search");
		searchButton = By.cssSelector("button[type='submit']");
	
		//homeLink = By.cssSelector("a.navbar-brand");
		
	}
        public void goToLoginPage() {
        	
        driver.findElement(myAccount).click();
        driver.findElement(loginLink).click();
  
        }
        
        public void searchProduct(String productName) {
            driver.findElement(searchBox).sendKeys(productName);
            driver.findElement(searchButton).click();
        }
        public void goToHomePage() {
            driver.findElement(homeLink).click();
        }
        
     
}
