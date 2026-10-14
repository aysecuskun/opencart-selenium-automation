package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	    private WebDriver driver;
	    private By myAccount;
	    private By loginLink;
	    private By searchBox;
	    private By searchButton;
	    private By homeLink;
	    
	    private By checkoutButton;
        public HomePage(WebDriver driver) {
		this.driver=driver;
		
		myAccount=By.xpath("//span[normalize-space()='My Account']");
		loginLink=By.xpath("//a[normalize-space()='Login']");
		searchBox = By.name("search");
		searchButton = By.cssSelector("button[type='submit']");
	    checkoutButton=By.cssSelector("a[title='Checkout'] span[class='d-none d-lg-inline']");
		//homeLink = By.cssSelector("a.navbar-brand");
		
	}
        
        public void clickCheckoutButton() {
        	
        	driver.findElement(checkoutButton).click();
        }
        public void goToLoginPage() {
        	
        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        	    wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
        	    wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
  
        }
        
        public void searchProduct(String productName) {
            driver.findElement(searchBox).sendKeys(productName);
            driver.findElement(searchButton).click();
        }
     
        
     
}
