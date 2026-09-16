package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	private WebDriver driver;
	private By checkoutHeading;
	private By firstName;
    private By lastName;
    private By address1;
    private By city;
    private By postCode;
    private By country;
    private By regionState;
    private By company;
    private By address2;

    private By shippingAddressContinueButton;
    // Shipping Address Validation
    private By validationMessages;
    // Shipping Method
    private By shippingMethodChooseButton;
    // Shipping Method Selection
    private By shippingMethodContinueButton;
    // Alert
    private By alertMessage;
    
    // Payment Method
    private By paymentMethodChooseButton;
    // Payment Method Selection
    private By paymentMethodContinueButton;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver=driver;
		checkoutHeading=By.xpath("//h1[normalize-space()='Checkout']");
		firstName=By.cssSelector("#input-shipping-firstname");
		lastName=By.cssSelector("#input-shipping-lastname");
		address1=By.cssSelector("#input-shipping-address-1");
		company=By.cssSelector("#input-shipping-company");
		address2=By.cssSelector("#input-shipping-address-2");
		city=By.cssSelector("#input-shipping-city");
		postCode=By.cssSelector("#input-shipping-postcode");
		country = By.id("input-shipping-country");       //dropdown
		regionState = By.id("input-shipping-zone");      //dropdown
		shippingAddressContinueButton=By.id("button-shipping-address");
		shippingMethodChooseButton=By.id("button-shipping-methods");
		paymentMethodChooseButton=By.id("button-payment-methods");
		
		shippingMethodContinueButton=By.id("button-shipping-method");
		paymentMethodContinueButton=By.id("button-payment-method");
		
	}
		
		public String getCheckoutHeading() {
			
			return driver.findElement(checkoutHeading).getText();
			
		}
		
		public void enterFirstName(String firstName) {
		    driver.findElement(this.firstName).sendKeys(firstName);
		}

		public void enterLastName(String lastName) {
		    driver.findElement(this.lastName).sendKeys(lastName);
		}

		public void enterAddress1(String address1) {
		    driver.findElement(this.address1).sendKeys(address1);
		}

		public void enterCompany(String company) {
		    driver.findElement(this.company).sendKeys(company);
		}

		public void enterAddress2(String address2) {
		    driver.findElement(this.address2).sendKeys(address2);
		}

		public void enterCity(String city) {
		    driver.findElement(this.city).sendKeys(city);
		}

		public void enterPostCode(String postCode) {
		    driver.findElement(this.postCode).sendKeys(postCode);
		}
		public void selectCountry(String countryName) {
		    Select countrySelect = new Select(driver.findElement(country));
		    countrySelect.selectByVisibleText(countryName);
		}
		public void selectRegionState(String regionName) {
		    Select regionSelect = new Select(driver.findElement(regionState));
		    regionSelect.selectByVisibleText(regionName);
		}
		
		public void clickShippingAddressContinue() {
		    driver.findElement(shippingAddressContinueButton).click();
		}

}
