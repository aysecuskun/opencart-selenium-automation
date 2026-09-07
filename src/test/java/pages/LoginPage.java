package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private By email;
	private By password;
	private By btnClickbutton;
	private By myAccountTitle;
	      
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		email=By.cssSelector("#input-email");
		password=By.cssSelector("#input-password");
		btnClickbutton=By.xpath("//button[normalize-space()='Login']");
		myAccountTitle=By.xpath("//h1[normalize-space()='My Account']");
	}
	 
	public void getLogin(String _email,String _password) {
		
		driver.findElement(email).sendKeys(_email);
		driver.findElement(password).sendKeys(_password);
		driver.findElement(btnClickbutton).click();
	}
	
	public boolean isLoginSuccessful() {
	    return driver.findElement(myAccountTitle).isDisplayed();
	}
	

}
