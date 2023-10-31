package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Products.GetProductByID;


public class GetProductByIDSteps {
    @Steps
    GetProductByID getProductByID;

    @Given("I set API endpoint for get a product by ID")
    public void setAPIForGetProductByID(){
        getProductByID.setAPIForGetProductByID();
    }
    @When("I send a request to get the product with the valid ID")
    public void sendGetRequestForGetProductByID(){
        getProductByID.sendGetRequestForGetProductByID();
    }

    @And("I should receive the details of the product associated with the provided ID")
    public void receiveDetailValidDataProductWithTheProvidedID(){
        getProductByID.receiveDetailValidDataProductWithTheProvidedID();
    }


    //Case Negative
    @Given("I set API endpoint for get a product with invalid ID")
    public void setInvalidAPIForGetProductByID(){
        getProductByID.setInvalidAPIForGetProductByID();
    }
    @When("I send a request GET to get product")
    public void sendGetRequestInvalidForGetProductByID(){
        getProductByID.sendGetRequestInvalidForGetProductByID();
    }
    @Then("I should receive a status code of 404")
    public void responseStatusCode404ForGetProductByID(){
        getProductByID.responseStatusCode404ForGetProductByID();
    }

    @And("I should receive an error message indicating that the product was not found")
    public void receiveMessageErrorShouldIndicatePageNotFound(){
        getProductByID.receiveMessageErrorShouldIndicatePageNotFound();
    }

}
