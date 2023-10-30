package starter.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class HomeProductsPages extends PageObject {
    private By title() {
        return By.xpath("//*[@id=\"app\"]/div/header/div/div[1]/h3");
    }
    private By detailButton() {
        return By.xpath("//*[@id=\"85519\"]/div/div[3]/div[2]/button[1]");
    }
    private By beliButton() {
        return By.xpath("//*[@id=\"85519\"]/div/div[3]/div[2]/button[2]/span");
    }
    private By cart() {
        return By.xpath("//*[@id=\"app\"]/div/header/div/button[1]");
    }
    @Step
    public boolean validateOnHomeProductsPage() {
        return $(title()).isDisplayed();
    }
    @Step
    public void clickDetailButton() {
        $(detailButton()).click();
    }
    @Step
    public void clickBeliButton() {
        $(beliButton()).click();
    }
    @Step
    public void clickCart() {
        $(cart()).click();
    }
}
