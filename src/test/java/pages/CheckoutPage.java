package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
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
  
    // Shipping Method
    private By shippingMethodChooseButton;
    // Shipping Method redio
	private By shippingMethodRadioButton;
    // Shipping Method Selection
    private By shippingMethodContinueButton;
    // Alert
    private By shippingMethodSuccessAlert;
    
    // Payment Method
    private By paymentMethodChooseButton;
    // Payment Method Selection
    private By paymentMethodContinueButton;
    
	// Shipping Address Validation
	private By firstNameValidation;
	private By lastNameValidation;
	private By address1Validation;
	private By cityValidation;
	private By postCodeValidation;
	private By regionStateValidation;
	
	// Shipping Method Validation
	private By shippingMethodValidation;

	// Payment Method Validation
	private By paymentMethodValidation;
	private By paymentMethodSuccessAlert;
	
	private By newAddressRadio;
	private By selectAddressRadio;
	private By shippingAddressSuccessAlert;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
		shippingAddressContinueButton=By.xpath("//button[@id='button-shipping-address']");
		shippingMethodChooseButton=By.id("button-shipping-methods");
		paymentMethodChooseButton=By.id("button-payment-methods");
		
		shippingMethodRadioButton = By.id("input-shipping-method-flat-flat");
		shippingMethodContinueButton=By.id("button-shipping-method");
		paymentMethodContinueButton=By.id("button-payment-method");
		
		firstNameValidation = By.id("error-shipping-firstname");
		lastNameValidation = By.id("error-shipping-lastname");
		address1Validation = By.id("error-shipping-address-1");
		cityValidation = By.id("error-shipping-city");
		postCodeValidation = By.id("error-shipping-postcode");
		regionStateValidation = By.id("error-shipping-zone");

		shippingMethodValidation = By.id("error-shipping-method");
		paymentMethodValidation = By.id("error-payment-method");
		newAddressRadio = By.id("input-shipping-new");
		selectAddressRadio=By.id("input-shipping-address");
		shippingAddressSuccessAlert =By.cssSelector("#alert .alert-success");
		shippingMethodSuccessAlert=By.xpath("//div[contains(@class,'alert-success') and normalize-space()='Success: You have changed shipping method!']");
		paymentMethodSuccessAlert=By.xpath("//div[contains(@class,'alert-success') and normalize-space()='Success: You have changed payment method!']");
		
		
	
	}
	
	
	public void selectShippingMethod() {
		 WebElement radio = wait.until(
			        ExpectedConditions.elementToBeClickable(
			            shippingMethodRadioButton
			        )
			    );

			    if (!radio.isSelected()) {
			        radio.click();
			    }
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

		    wait.until(driver -> {
		        Select select = new Select(driver.findElement(country));
		        return select.getFirstSelectedOption()
		                     .getText()
		                     .equals(countryName);
		    });
		}
		public void selectRegionState(String regionName) {
			   Select select =
			            new Select(driver.findElement(regionState));

			    select.selectByVisibleText(regionName);
		}
		
		public void selectExistingAdddress(String selectAddress) {  //tanımlı adreslerden seçme 
			
			 Select select =
			            new Select(driver.findElement(selectAddressRadio));
             select.selectByVisibleText(selectAddress);
			  
		}
		
		public void clickShippingAddressContinue() {
			WebElement button = driver.findElement(shippingAddressContinueButton);

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block: 'center'});",
		        button
		    );

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].click();",
		        button
		    );
		}
		
		public String getFirstNameValidation() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( firstNameValidation ) );
			return element.getAttribute("textContent").trim();
		}

		public String getLastNameValidation() {
			
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( lastNameValidation ) );
			return element.getAttribute("textContent").trim();
		}

		public String getAddress1Validation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( address1Validation ) );
			return element.getAttribute("textContent").trim();
			
		}

		public String getCityValidation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( cityValidation ) );
			return element.getAttribute("textContent").trim();
			
		}

		public String getPostCodeValidation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( postCodeValidation ) );
			return element.getAttribute("textContent").trim();
			
		}

		public String getRegionStateValidation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( regionStateValidation ) );
			return element.getAttribute("textContent").trim();
			
		}

		public String getShippingMethodValidation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( shippingMethodValidation ) );
			return element.getAttribute("textContent").trim();
			
		}

		public String getPaymentMethodValidation() {
			WebElement element = wait.until( ExpectedConditions.visibilityOfElementLocated( paymentMethodValidation ) );
			return element.getAttribute("textContent").trim();
		
		}
		
		public boolean isFirstNameValidationDisplayed() {
		    return driver.findElements(firstNameValidation).size() > 0 
		            && driver.findElement(firstNameValidation).isDisplayed();
		}
		
		public boolean isAddress1ValidationDisplayed() {
		    return driver.findElements(address1Validation).size() > 0   //validation mesajı var mı yok mu diye kontrol et
		            && driver.findElement(address1Validation).isDisplayed(); 
		}

		public void selectNewAddress() {
		    driver.findElement(newAddressRadio).click();
		}
		
		public String getShippingAddressSuccessAlertMessage() {
		    WebElement alert = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(shippingAddressSuccessAlert)
		    );

		    return alert.getText().trim();
		}
		
		
		
		public void clickShippingMethodChoose() {
		    driver.findElement(shippingMethodChooseButton).click();
		}
		
		public void clickShippingMethodContinue() {
		    driver.findElement(shippingMethodContinueButton).click();
		}
		
		public String getShippingMethodSuccessAlertMessage() {

		    WebElement alert = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                shippingMethodSuccessAlert
		            )
		        );

		        return alert.getText().trim();
		}
		
		public String getPaymentMethodSuccessAlertMessage() {

		    WebElement alert = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            paymentMethodSuccessAlert
		        )
		    );

		    return alert.getText().trim();
		}
		
		public void clickPaymentMethodChoose() {
		    driver.findElement(paymentMethodChooseButton).click();
		}
		
		public void clickPaymentMethodContinue() {
		    driver.findElement(paymentMethodContinueButton).click();
		}
}
