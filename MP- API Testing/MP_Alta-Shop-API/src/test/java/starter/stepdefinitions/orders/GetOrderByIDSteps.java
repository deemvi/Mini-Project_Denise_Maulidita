package starter.stepdefinitions.orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Orders.GetOrderByID;

public class GetOrderByIDSteps {

    @Steps
    GetOrderByID getOrderByID;

    @Given("I set API endpoint for get a order by ID")
    public void setApiEndpointGetOrderByID() {
        getOrderByID.setApiEndpointGetOrderByID();
    }
    @When("I send a request to get the order with the valid ID")
    public void sendGetOrderByID() {
        getOrderByID.sendGetOrderByID();
    }
    @And("I should receive the details of the order associated with the provided ID")
    public void receiveValidDataForGetOrderByID() {
        getOrderByID.receiveValidDataForGetOrderByID();
    }

    @Given("I set API endpoint for get a order with invalid ID")
    public void setInvalidIDForGetOrderByID() {
        getOrderByID.setInvalidIDForGetOrderByID();
    }
    @When("I send a request GET to get order by id")
    public void sendGetRequestForGetOrderByID() {
        getOrderByID.sendGetRequestForGetOrderByID();
    }
}
