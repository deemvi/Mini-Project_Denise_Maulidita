package starter.pages.authentication;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private By title() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[1]");
    }
    private By emailField() {
        return By.xpath("//*[@id=\"input-18\"]");
    }

    private By passwordField() {
        return By.xpath("//*[@id=\"input-21\"]");
    }

    private By loginButton() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[2]/form/div[3]/button");
    }

    @Step
    public boolean displayLoginPage() {
         return $(title()).isDisplayed();
    }
    private By errorMessage() {
        return By.className("v-alert__content");
    }

    @Step
    public boolean validateOnLoginPage() {
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username) {
        $(emailField()).type(username);
    }

    @Step
    public void inputUnregisteredEmail(String email) {
        $(emailField()).type(email);
    }

    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void inputUnregisteredPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton() {
        $(loginButton()).click();
    }

    @Step
    public boolean validateErrorMessageIsDisplayed() {
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean validateEqualErrorMessage(String message) {
        return $(errorMessage()).getText().equalsIgnoreCase(message);
    }

}