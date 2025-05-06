package amazon.businessLayer;

import dev.failsafe.internal.util.Assert;
import amazon.screen.SearchScreen;
import amazon.utils.ContextDataStore;
import org.apache.hc.core5.util.Asserts;

import java.util.logging.Logger;

public class SearchBL {
    private Logger logger = Logger.getLogger(String.valueOf(SearchBL.class));

    public SearchBL() {
        logger.info("INSIDE THE LOGIN BL Class");
    }

    public SearchBL userSearchesTheProductInAmazonPortal(String product) {
        ContextDataStore.setData("PRODUCT_NAME", product);
        SearchScreen.get()
                .userClicksOnSearchBox()
                .userEntersProductName(product)
                .userSubmitsTheSearchButton();

        return this;
    }

    public void userAddsTheSearchedPhoneInCart() {
        SearchScreen searchScreen = SearchScreen.get();

        boolean isSearchedProductVisible = searchScreen.isSearchProductVisible();
        Assert.isTrue(isSearchedProductVisible, "Searched Product is not displayed as expected");

        boolean isProductAddedInCart = searchScreen
                .userAddsTheSearchedPhoneInCart()
                .isSearchProductDisplayedInCart();
        Assert.isTrue(isSearchedProductVisible, "Unable to Add product from cart");
    }

    public SearchBL userRemovesThePhoneFromCart() {
        boolean isProductRemoveFromCart = SearchScreen.get()
                .userRemovesTheSearchedPhoneFromCart()
                .isSearchProductDisplayedInCart();

        Assert.isTrue(!isProductRemoveFromCart, "Unable to Remove product from cart");
        return this;
    }

    public SearchBL userValidatesThePriceOfProduct() {
        String actualPrice = SearchScreen.get()
                .userFetchesThePriceOfSearchedPhone();

        String expectedPrice = (String) ContextDataStore.getData("PRODUCT_PRICE");

        Asserts.check((actualPrice.equalsIgnoreCase(expectedPrice)), "Price mismatch!");
        return this;
    }
}