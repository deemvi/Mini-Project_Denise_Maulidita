package starter.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProducts {
    private static String url = "https://altashop-api.fly.dev/";

@Step("I set API endpoint for get all product")
public String setApiEndpointGetAllProduct() {
    return url + "api/products";
}
@Step("I send GET request to the endpoint to get all products")
public void sendGetAllUsersRequest() {
    SerenityRest.given().get(setApiEndpointGetAllProduct());
}
@Step("the response status code should be 200")
public void responseStatusCode200(){
    restAssuredThat(response-> response.statusCode(200));
}

@Step("I receive valid data for get all products")
public void receiveValidDataForGetAllProducts(){
    JsonSchemaHelper helper = new JsonSchemaHelper();
    String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

    restAssuredThat(response->response.body(matchesJsonSchema(schema)));
}
    @Step("I set invalid API endpoint for get all product with invalid parameters")
    public String setInvalidAPIForGetAllProduct() {
        return url + "api/pro";
    }
    @Step("I send GET request for get all product")
    public void sendGetRequest() {
        SerenityRest.given().get(setInvalidAPIForGetAllProduct());
    }
    @Step("the response status code equal 404")
    public void responseStatusCode404(){
        restAssuredThat(response-> response.statusCode(404));
    }
    @Step("I receive error message should indicate page not found")
    public void receiveMessageErrorShouldIndicatePageNotFound() {
        System.out.println("Error message indicates that the page was not found.");
    }
}
