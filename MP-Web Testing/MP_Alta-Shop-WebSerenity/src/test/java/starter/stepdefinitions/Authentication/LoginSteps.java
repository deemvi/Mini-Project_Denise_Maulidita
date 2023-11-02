package starter.stepdefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.authentication.LoginPage;
import starter.pages.products.HomeProductsPages;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    HomeProductsPages homeProducts;

    @Given("I am on the login page")
    public void onTheLoginPage() {
        loginPage.openUrl("https://alta-shop.vercel.app/auth/login");
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }

    @When("I input username")
    public void inputValidUsername() {
        loginPage.inputUsername("de");
    }


    @And("I input password")
    public void inputValidPassword() {
        loginPage.inputPassword("de");
    }

    @And("I click login button for registered account")
    public void clickLoginButtonForRegisteredAccount() {
        loginPage.clickLoginButton();
    }

    @And("I click login button for unregistered account")
    public void clickLoginButtonForUnregisteredAccount() {
        loginPage.clickLoginButton();
    }


    @Then("I am on the homepage")
    public void onTheHomeProductsPage() {
        homeProducts.validateOnHomeProductsPage();
    }

    @When("I input unregistered email")
    public void inputUnregisteredEmail() {
        loginPage.inputUnregisteredEmail("another89@gmail.com");
    }

    @And("I input unregistered password")
    public void inputUnregisteredPassword() {
        loginPage.inputUnregisteredPassword("90");
    }

    @Then("I can see error message {string}")
    public void validErrorMessageIsDisplayed(String message) {
        Assertions.assertTrue(loginPage.validateErrorMessageIsDisplayed());
        Assertions.assertFalse(loginPage.validateEqualErrorMessage(message));
    }

}