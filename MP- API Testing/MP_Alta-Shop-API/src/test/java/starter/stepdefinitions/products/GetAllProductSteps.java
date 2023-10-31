package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Products.GetAllProducts;


public class GetAllProductSteps {
    @Steps
    GetAllProducts getAllProducts;

    @Given("I set API endpoint for get all product")
    public void setApiEndpointGetAllProduct(){
        getAllProducts.setApiEndpointGetAllProduct();
    }
    @When("I send GET request to the endpoint to get all products")
    public void sendGetAllUsersRequest(){
        getAllProducts.sendGetAllUsersRequest();
    }
    @Then("the response status code should be 200")
    public void responseStatusCode200(){
        getAllProducts.responseStatusCode200();
    }
    @And("I receive valid data for get all products")
    public void receiveValidDataForGetAllProducts(){
        getAllProducts.receiveValidDataForGetAllProducts();
    }
    @Given("I set invalid API endpoint for get all product with invalid parameters")
    public void setInvalidAPIForGetAllProduct(){
        getAllProducts.setInvalidAPIForGetAllProduct();
    }
    @When("I send GET request for get all product")
    public void sendGetRequest(){
        getAllProducts.sendGetRequest();
    }
    @Then("the response status code equal 404")
    public void responseStatusCode404(){
        getAllProducts.responseStatusCode404();
    }

    @And("I receive error message should indicate page not found")
    public void receiveMessageErrorShouldIndicatePageNotFound(){
        getAllProducts.receiveMessageErrorShouldIndicatePageNotFound();
    }

}
