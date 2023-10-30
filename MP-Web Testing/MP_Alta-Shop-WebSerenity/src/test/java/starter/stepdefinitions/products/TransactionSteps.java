package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.products.DetailProductPages;
import starter.pages.products.HomeProductsPages;
import starter.pages.products.TransactionPages;

public class TransactionSteps {

    @Steps
    TransactionPages transactionPages;



    @Then("I can track my order")
    public void validateListTransaction() {
        transactionPages.validateListTransactions();
    }
    @Then("I noticed that I couldn't continue the purchasing process")
    public void validateCouldNotContinueThePurchasingProcess() {
        transactionPages.validateListTransactions();
    }

}