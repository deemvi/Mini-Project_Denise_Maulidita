package starter.stepdefinitions.authentications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("I set API endpoint for login")
    public void setApiEndpoint() {
        login.setApiEndpoint();
    }

    @When("I send request to login with valid email {string} and valid password {string}")
    public void sendLoginRequest(String email, String password) {
        login.sendLoginRequest(email, password);
    }

    @Then("I receive status code 200")
    public void receiveStatusCode200() {
        login.receiveStatusCode200();
    }

    @And("I receive valid data for login")
    public void receiveValidDataForLogin() {
        login.receiveValidDataForLogin();
    }

    @When("I send request to login with unregistered email {string} and valid password {string}")
    public void sendLoginRequestWithUnregisteredCredentials(String email, String password) {
        login.sendLoginRequestWithUnregisteredCredentials(email, password);
    }

    @When("I receive status code 400")
    public void receiveStatusCode400() {
        login.receiveStatusCode400();
    }
    @When("I receive message error")
    public void receiveMessageError() {
        login.receiveMessageError();
    }
}
