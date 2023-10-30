package starter.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class CartPages extends PageObject {
    private By title() {
        return By.xpath("//*[@id=\"app\"]/div/header/div/div[1]/h3");
    }
    private By listCart() {
        return By.xpath("//*[@id=\"order-85520\"]/div[1]");
    }
    private By bayarButton() {
        return By.xpath("//*[@id=\"button-bayar\"]");
    }
   private By listCartIsEmpty() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div/div[1]");
    }

    @Step
    public boolean validateCartPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validateListCart() {
        return $(listCart()).isDisplayed();
    }

    @Step
    public void clickBayarButton() {
        $(bayarButton()).click();
    }

    @Step
    public boolean validateErrorMessageIsDisplayed() {
        return $(listCartIsEmpty()).isDisplayed();
    }

    @Step
    public boolean validateEqualErrorMessage(String message) {
        return $(listCartIsEmpty()).getText().equalsIgnoreCase(message);
    }

}
