package starter.stepdefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.authentication.LoginPage;
import starter.pages.authentication.RegisterPages;
import starter.pages.products.HomeProductsPages;

public class RegisterSteps {

    @Steps
    RegisterPages registerPages;

    @Steps
    LoginPage loginPage;

    @Given("I am on the register page")
    public void validateOnRegisterPage() {
        registerPages.openUrl("https://alta-shop.vercel.app/auth/register");
        registerPages.validateOnRegisterPage();
    }

    @When("I input nama lengkap")
    public void inputUsername() {
        registerPages.inputUsername("John Doe Bahar");
    }

    @And("I input email")
    public void inputEmail() {
        registerPages.inputEmail("john12345@gmail.com");
    }

    @And("I input password for register")
    public void inputPassword() {
        registerPages.inputPassword("johdoe1234567");
    }

    @And("I input register button")
    public void clickRegisterButton() {
        registerPages.clickRegisterButton();
    }

    @Then("I redirected to login page")
    public void onTheLoginPage() {
        loginPage.displayLoginPage();
    }

            //case negative/////
    @When("I not input nama lengkap")
    public void inputInvalidNamaLengkap() {
        registerPages.inputInvalidNamaLengkap("");
    }

    @And("I not input email")
    public void inputInvalidEmail() {
        registerPages.inputInvalidEmail("");
    }

    @And("I not input password")
    public void inputInvalidPassword() {
        registerPages.inputInvalidPassword("");
    }
    @And("I click register")
    public void clickRegister() {
        registerPages.clickRegisterButton();
    }

    @Then("registration failed and there is no error message")
    public void validateErrorMessageIsDisplayed() {
        registerPages.validateErrorMessageIsDisplayed();
    }

}