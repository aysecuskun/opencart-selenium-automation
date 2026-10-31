
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

    private WebDriver driver;
    private WebDriverWait wait;

    private By noProductMessage;
    private By searchHeading;
    private By productImages;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        noProductMessage = By.cssSelector("#content p");
        searchHeading = By.cssSelector("#content h1");
        productImages = By.cssSelector("div.product-thumb img");
    }

    public boolean isSearchPageDisplayed(String productName) {
        try {
            wait.until(ExpectedConditions.urlContains("route=product/search"));

            String expectedHeading;

            if (productName == null || productName.trim().isEmpty()) {
                expectedHeading = "Search -";
            } else {
                expectedHeading = "Search - " + productName.trim();
            }

            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                searchHeading, expectedHeading
            ));

            return driver.getCurrentUrl().contains("route=product/search")
                && driver.findElement(searchHeading).getText().trim()
                    .equals(expectedHeading);

        } catch (Exception e) {
            return false;
        }
    }

    public String getSearchHeading() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchHeading)
        ).getText().trim();
    }

    public String getProductName() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(productImages)
        ).getAttribute("alt");
    }

    public boolean isProductDisplayed(String productName) {

        By product = By.xpath(
            "//div[contains(@class,'product-thumb')]//img[@alt='" + productName + "']"
        );

        return !driver.findElements(product).isEmpty();
    }

    // Görselin gerçekten yüklenip yüklenmediğini kontrol eder.
    public boolean isProductImageLoaded(String productName) {

        By product = By.xpath(
            "//div[contains(@class,'product-thumb')]//img[@alt='" + productName + "']"
        );

        try {
            WebElement image = wait.until(
                ExpectedConditions.visibilityOfElementLocated(product)
            );

            return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && arguments[0].naturalWidth > 0;",
                image
            );

        } catch (Exception e) {
            return false;
        }
    }
    
    public By productLink(String productName) {
        return By.xpath(
            "//div[contains(@class,'product-thumb')]//a[img[@alt='" 
            + productName + "']]"
        );
    }

    public void clickProduct(String productName) {

        WebElement product = wait.until(
            ExpectedConditions.elementToBeClickable(productLink(productName))
        );

        new Actions(driver)
            .moveToElement(product)
            .click()
            .perform();
    }

    public String getNoProductMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(noProductMessage)
        ).getText().trim();
    }

    public boolean isNoProductMessageDisplayed() {
        return !driver.findElements(noProductMessage).isEmpty()
            && driver.findElement(noProductMessage).isDisplayed();
    }

    public boolean areProductImagesAbsent() {
        return driver.findElements(productImages).isEmpty();
    }
}
