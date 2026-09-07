package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	    private WebDriver driver;
	    private By myAccount;
	    private By loginLink;

        public HomePage(WebDriver driver) {
		this.driver=driver;
		
		myAccount=By.xpath("//span[normalize-space()='My Account']");
		loginLink=By.xpath("//a[normalize-space()='Login']");
		
		
	}
        public void goToLoginPage() {
        	
        driver.findElement(myAccount).click();
        driver.findElement(loginLink).click();
        	
        }
        
        
	
}
