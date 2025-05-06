package amazon.screen;

import amazon.screen.web.SearchScreenWeb;
import amazon.utils.CreateDriver;
import org.openqa.selenium.WebDriver;

public abstract class SearchScreen {


    public static SearchScreen get() {
        WebDriver driver = (new CreateDriver()).getDriver();
        return new SearchScreenWeb(driver);
    }

    public abstract SearchScreen userClicksOnSearchBox();

    public abstract SearchScreen userEntersProductName(String product);

    public abstract SearchScreen userSubmitsTheSearchButton();

    public abstract boolean isSearchProductVisible();

    public abstract SearchScreen userAddsTheSearchedPhoneInCart();

    public abstract boolean isSearchProductDisplayedInCart();

    public abstract SearchScreen userRemovesTheSearchedPhoneFromCart();

    public abstract String userFetchesThePriceOfSearchedPhone();
}
