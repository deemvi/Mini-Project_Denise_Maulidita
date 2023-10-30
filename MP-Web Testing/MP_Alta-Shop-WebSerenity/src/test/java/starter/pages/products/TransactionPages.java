package starter.pages.products;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TransactionPages extends PageObject {
    private By title() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/h1");
    }
    private By listTransactions() {
        return By.xpath("//*[@id=\"app\"]/div/main/div/div/div/div/div[1]/table/thead/tr/th[1]");
    }


    public boolean validateTransactionPage() {
        return $(title()).isDisplayed();
    }
    public boolean validateListTransactions() {
        return $(listTransactions()).isDisplayed();
    }

}
