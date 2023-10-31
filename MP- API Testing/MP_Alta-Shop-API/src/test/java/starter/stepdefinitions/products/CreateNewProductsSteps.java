package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Products.CreateNewProducts;
import starter.Products.GetAllProducts;


public class CreateNewProductsSteps {
    @Steps
    CreateNewProducts createNewProducts;

    @Given("I set API endpoint for creating a new product is available")
    public void setApiEndpointCreateNewProduct(){
        createNewProducts.setApiEndpointCreateNewProduct();
    }
    @When("I send a request POST to create a new product with valid inputs")
    public void sendCreateUserRequest(){
        createNewProducts.sendCreateUserRequest();
    }
    @And("I should receive a status code of 200")
    public void receiveStatusCode200(){
        createNewProducts.receiveStatusCode200();
    }
    @Then("I should receive the details of the newly created product")
    public void receiveDetailsOfTheNewlyCreatedProduct(){
        createNewProducts.receiveDetailsOfTheNewlyCreatedProduct();
    }



    @When("I send a request to create a new product with required fields")
    public void sendRequestRequiredFields(){
        createNewProducts.sendRequestRequiredFields();
    }
    @And("I should receive a status code of 500")
    public void responseStatusCode400(){
        createNewProducts.responseStatusCode500();
    }

    @Then("I should receive an error message indicating the missing fields")
    public void receiveMessageErrorIndicatingMessageError(){
        createNewProducts.receiveMessageErrorIndicatingMessageError();
    }

}
