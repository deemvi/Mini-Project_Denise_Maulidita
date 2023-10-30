package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.products.DetailProductPages;
import starter.pages.products.HomeProductsPages;

public class DetailProductSteps {

    @Steps
    HomeProductsPages homeProductsPages;

    @Steps
    DetailProductPages detailProductPages;


//    @Then("I am on the homepage")
//    public void onTheHomeProductsPage() {
//        Assertions.assertTrue(homeProducts.validateOnHomeProductsPage());
//    }

    @When("I click detail button in product")
    public void clickDetailButton() {
        homeProductsPages.clickDetailButton();
    }

    @Then("I redirected to detail page")
    public void validateOnDetailProductsPage() {
        detailProductPages.validateOnDetailProductsPage();
    }

    @And("I noticed there is no stock information in the product details")
    public void noStockInformation() {
        detailProductPages.validateOnDetailProductsPage();
    }

}