package steps;

import amazon.businessLayer.SearchBL;
import io.cucumber.java.en.Given;

public class SearchSteps {

    @Given("User searches {string} in Amazon Portal")
    public void user_searches_in_search_box(String string) {
        new SearchBL().userSearchesTheProductInAmazonPortal(string);
    }

    @Given("User selects and adds the random phone in Cart")
    public void user_adds_the_any_iphone_in_cart() {
        new SearchBL().userAddsTheSearchedPhoneInCart();
    }

    @Given("User removes the phone from cart")
    public void user_removes_the_phone_from_cart() {
        new SearchBL().userRemovesThePhoneFromCart();
    }

    @Given("User validates the price of product")
    public void user_validates_the_price_of_product() {
        new SearchBL().userValidatesThePriceOfProduct();
    }
}
