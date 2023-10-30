package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.products.CartPages;
import starter.pages.products.DetailProductPages;
import starter.pages.products.HomeProductsPages;
import starter.pages.products.TransactionPages;

public class CheckoutSteps {

    @Steps
    HomeProductsPages homeProductsPages;

    @Steps
    CartPages cartPages;

    @Steps
    TransactionPages transactionPages;

//////////////positive steps
    @And("I see list of product in cart page")
    public void validateListCart() {
        cartPages.validateListCart();
    }


    @And("I click bayar button")
    public void clickBayarButton() {
        cartPages.clickBayarButton();
    }

    @Then("I redirected to the transaction page")
    public void validateTransactionPage() {
        transactionPages.validateTransactionPage();
    }

    ///////////negative steps
    @When("I click cart icon with empty list")
    public void clickCartIconWIthEmptyList() {
        homeProductsPages.clickCart();
    }
    @And("I tried to proceed with checkout without any products in the cart")
    public void clickBayarButtonWithoutAnyProductsInTheCart() {
        cartPages.clickBayarButton();
    }

    @Then("The system cannot process the checkout with error message {string}")
    public void cannotProcessTheCheckoutWithErrorMessage(String message) {
        cartPages.validateErrorMessageIsDisplayed();
        cartPages.validateEqualErrorMessage(message);
    }

}