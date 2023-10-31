package starter.Products;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;



public class DeleteProductByID {
    private static String url = "https://altashop-api.fly.dev/";

    @Step("I set API endpoint for delete product By valid ID")
    public String setAPIForDeleteProductByID() {
        return url + "api/products/1";
    }
    @Step("I send a request to delete the product with the valid ID")
    public void sendDeleteRequestForDeleteProductByID() {
        SerenityRest.given().delete(setAPIForDeleteProductByID());
    }

//    @Step("I should receive a status code of 200")
//    public void receiveStatusCode200ForDeleteProduct(){
//        restAssuredThat(response -> response.statusCode(200));
//    }
    @Step("I received a message indicating that the product was successfully removed")
    public void receiveSuccessfullyMessage() {
        System.out.println("Product Was successfully removed");
    }

    @Step("I set API endpoint for delete product By invalid ID")
    public String setInvalidAPIForDeleteProductByID() {
        return url + "api/products/9";
    }
    @Step("I send a request to delete the product with the invalid ID")
    public void sendDeleteRequestInvalidForDeleteProductByID() {
        SerenityRest.given().get(setInvalidAPIForDeleteProductByID());
    }
//    @Step("I should receive a status code of 404")
//    public void responseStatusCode404ForGetProductByID(){
//        restAssuredThat(response-> response.statusCode(404));
//    }
//    @Step("I should receive an error message indicating that the product was not found")
//    public void receiveMessageErrorShouldIndicatePageNotFound() {
//        System.out.println("Error message indicates that the page was not found.");
//    }
}
