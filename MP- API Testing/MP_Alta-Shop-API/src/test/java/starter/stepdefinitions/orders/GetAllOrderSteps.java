package starter.stepdefinitions.orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.Login;
import starter.Orders.CreateNewOrder;
import starter.Orders.GetAllOrder;

public class GetAllOrderSteps {

    @Steps
    GetAllOrder getAllOrder;

    @Given("I set API endpoint for get all order")
    public void setApiEndpointGetAllOrder() {
        getAllOrder.setApiEndpointGetAllOrder();
    }
    @When("I send GET request to the endpoint to get all order")
    public void sendGetAllOrderRequest() {
        getAllOrder.sendGetAllOrderRequest();
    }
    @And("I receive valid data for get all order")
    public void receiveValidDataForGetAllOrder() {
        getAllOrder.receiveValidDataForGetAllOrder();
    }

    @Given("I set invalid API endpoint for get all order with invalid parameters")
    public void setInvalidAPIForGetAllOrder() {
        getAllOrder.setInvalidAPIForGetAllOrder();
    }
    @And("I send GET request for get all order")
    public void sendGetRequestForGetAllOrder() {
        getAllOrder.sendGetRequestForGetAllOrder();
    }
}
