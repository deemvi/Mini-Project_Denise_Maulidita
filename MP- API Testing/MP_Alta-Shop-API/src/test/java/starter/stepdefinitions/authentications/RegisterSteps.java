package starter.stepdefinitions.authentications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.Register;


public class RegisterSteps {

    @Steps
    Register register;

    @Given("I set API endpoint for register")
    public void setApiEndpoint() {
        register.setApiEndpoint();
    }

    @When("I send request to register")
    public void sendRegisterRequest() {
        register.sendRegisterRequest();
    }

    @And("I receive status code 200 for register")
    public void receiveStatusCode200ForRegister() {
        register.receiveStatusCode200ForRegister();
    }

    @Then("I receive valid data for register")
    public void receiveValidRegisterData() {
        register.receiveValidRegisterData();
    }

    @When("I send a request with existing email")
    public void sendRegisterRequestWithExistingEMail() {
        register.sendRegisterRequestWithExistingEMail();
    }
    @And("I should receive a status code of 400")
    public void shouldReceiveStatusCode400() {
        register.shouldReceiveStatusCode400();
    }


    @Then("I receive an error message indicating duplicate key value")
    public void receiveMessageErrorIndicatingDuplicateKeyValue() {
        register.receiveMessageErrorIndicatingDuplicateKeyValue();
    }
}
