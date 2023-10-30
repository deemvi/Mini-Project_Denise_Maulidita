package starter.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class DetailProductPages extends PageObject {

    private By detailProduct() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div");
    }

    @Step
    public boolean validateOnDetailProductsPage() {
        return $(detailProduct()).isDisplayed();
    }

}
