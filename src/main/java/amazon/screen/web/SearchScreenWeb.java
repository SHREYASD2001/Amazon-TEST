package amazon.screen.web;

import amazon.screen.SearchScreen;
import amazon.utils.ContextDataStore;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchScreenWeb extends SearchScreen {

    private final WebDriver driver;

    private final By byMainSearchBoxCssSelector = By.cssSelector("input#twotabsearchtextbox");
    private final By bySearchedItemCardCssSelector = By.cssSelector("div.puis-card-container");
    private final By byTitleOfItemCardCssSelector = By.cssSelector("h2.a-color-base.a-text-normal > span");
    private final By bySubmitButtonId = By.id("nav-search-submit-button");
    private final By byAddButtonId = By.cssSelector("button#a-autoid-1-announce");

    public SearchScreenWeb(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public SearchScreen userClicksOnSearchBox() {
        performsExplicitClick(byMainSearchBoxCssSelector);
        return this;
    }

    @Override
    public SearchScreen userEntersProductName(String product) {
        waitTillElementIsPresent(byMainSearchBoxCssSelector).sendKeys(product);
        return this;
    }

    @Override
    public SearchScreen userSubmitsTheSearchButton() {
        waitTillElementIsPresent(bySubmitButtonId).click();
        return this;
    }

    @Override
    public boolean isSearchProductVisible() {
        String productName = (String) ContextDataStore.getData("PRODUCT_NAME");

        waitTillPageIsLoaded(bySearchedItemCardCssSelector);
        List<WebElement> listOfCard = driver.findElements(bySearchedItemCardCssSelector);
        for (WebElement element : listOfCard) {
            String text = element.findElement(byTitleOfItemCardCssSelector).getText();
            if (text.contains(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SearchScreen userAddsTheSearchedPhoneInCart() {
        String productName = (String) ContextDataStore.getData("PRODUCT_NAME");
        List<WebElement> listOfCard = driver.findElements(bySearchedItemCardCssSelector);
        for (WebElement element : listOfCard) {
            String text = element.findElement(byTitleOfItemCardCssSelector).getText();
            if (text.contains(productName)) {
                WebElement element1 = element.findElement(byAddButtonId);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element1);
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    System.out.println("Added wait");
                }
                String price = element.findElement(By.cssSelector("span.a-price-whole")).getText();
                ContextDataStore.setData("PRODUCT_PRICE", price);
                break;
            }
        }
        return this;
    }

    @Override
    public boolean isSearchProductDisplayedInCart() {
        String productName = (String) ContextDataStore.getData("PRODUCT_NAME");

        waitTillPageIsLoaded(bySearchedItemCardCssSelector);
        List<WebElement> listOfCard = driver.findElements(bySearchedItemCardCssSelector);
        for (WebElement element : listOfCard) {
            String text = element.findElement(byTitleOfItemCardCssSelector).getText();
            if (text.contains(productName)) {
                try {
                    return element.findElement(By.cssSelector("button[aria-label='Decrease quantity by one']> span.a-icon.a-icon-small-trash")).isDisplayed();
                } catch ( Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public SearchScreen userRemovesTheSearchedPhoneFromCart() {
        String productName = (String) ContextDataStore.getData("PRODUCT_NAME");
        waitTillPageIsLoaded(bySearchedItemCardCssSelector);
        List<WebElement> listOfCard = driver.findElements(bySearchedItemCardCssSelector);
        for (WebElement element : listOfCard) {
            String text = element.findElement(byTitleOfItemCardCssSelector).getText();
            if (text.contains(productName)) {
                element.findElement(By.cssSelector("button[aria-label='Decrease quantity by one']> span.a-icon.a-icon-small-trash")).click();
                break;
            }
        }
        return this;
    }

    @Override
    public String userFetchesThePriceOfSearchedPhone() {
        String productName = (String) ContextDataStore.getData("PRODUCT_NAME");
        List<WebElement> listOfCard = driver.findElements(bySearchedItemCardCssSelector);
        for (WebElement element : listOfCard) {
            String text = element.findElement(byTitleOfItemCardCssSelector).getText();
            if (text.contains(productName)) {
                return element.findElement(By.cssSelector("span.a-price-whole")).getText();
            }
        }
        return "";
    }

    //


    private WebElement waitTillElementIsPresent(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void performsExplicitClick(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void waitTillPageIsLoaded(By locator) {
        waitTillElementIsPresent(locator);
    }
}