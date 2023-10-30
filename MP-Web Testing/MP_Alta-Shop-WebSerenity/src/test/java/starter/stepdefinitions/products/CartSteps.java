package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.products.CartPages;
import starter.pages.products.DetailProductPages;
import starter.pages.products.HomeProductsPages;

public class CartSteps {

    @Steps
    HomeProductsPages homeProductsPages;

    @Steps
    CartPages cartPages;



    @When("I click beli button in product")
    public void clickDetailButton() {
        homeProductsPages.clickBeliButton();
    }


    @And("I click cart icon")
    public void clickCart() {
        homeProductsPages.clickCart();
    }

    @Then("I redirected to cart page")
    public void redirectedCartPage() {
        cartPages.validateCartPage();
    }

    @Then("I redirected to empty cart page with message error {string}")
    public void redirectedCartPageWithMessageError(String message) {
        cartPages.validateErrorMessageIsDisplayed();
        cartPages.validateEqualErrorMessage(message);
    }


}