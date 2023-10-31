package starter.stepdefinitions.orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.Login;
import starter.Orders.CreateNewOrder;

public class CreateNewOrderSteps {

    @Steps
    CreateNewOrder createNewOrder;

    @Given("I set API for create new orders")
    public void setApiEndpointCreateNewOrder() {
        createNewOrder.setApiEndpointCreateNewOrder();
    }
    @When("I send request for create new order")
    public void sendCreateNewOrder() {
        createNewOrder.sendCreateNewOrder();
    }
    @And("I receive valid data for create new order")
    public void receiveValidDataForCreateNewOrder() {
        createNewOrder.receiveValidDataForCreateNewOrder();
    }

    @When("I send request with required input")
    public void sendCreateNewOrderWithRequiredInputs() {
        createNewOrder.sendCreateNewOrderWithRequiredInputs();
    }
}
