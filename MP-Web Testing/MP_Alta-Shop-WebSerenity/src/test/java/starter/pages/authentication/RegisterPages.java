package starter.pages.authentication;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class RegisterPages extends PageObject {
    private By title() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[1]");
    }
    private By namaLengkapField() {
        return By.xpath("//*[@id=\"input-18\"]");
    }

    private By emailField() {
        return By.xpath("//*[@id=\"input-21\"]");
    }

    private By passwordField() {
        return By.xpath("//*[@id=\"input-24\"]");
    }

    private By errorMessageRegister() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[2]/div[1]/div");
    }

    private By registerButton() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div[2]/form/div[4]/button");
    }

    @Step
    public boolean validateOnRegisterPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public void inputUsername(String namaLengkap) {
        $(namaLengkapField()).type(namaLengkap);
    }

    @Step
    public void inputEmail(String email) {
        $(emailField()).type(email);
    }
    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }
    @Step
    public void inputInvalidNamaLengkap(String namaLengkap) {
        $(emailField()).type(namaLengkap);
    }

    @Step
    public void inputInvalidEmail(String email) {
        $(emailField()).type(email);
    }
    @Step
    public void inputInvalidPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void clickRegisterButton() {
        $(registerButton()).click();
    }

    @Step
    public boolean validateErrorMessageIsDisplayed() {
        return $(errorMessageRegister()).isDisplayed();
    }

    @Step
    public boolean validateEqualErrorMessage(String message) {
        return $(errorMessageRegister()).getText().equalsIgnoreCase(message);
    }

}