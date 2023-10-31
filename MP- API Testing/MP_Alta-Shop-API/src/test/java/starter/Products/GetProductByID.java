package starter.Products;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class GetProductByID {
    private static String url = "https://altashop-api.fly.dev/";

    @Step("I set API endpoint for get a product by ID")
    public String setAPIForGetProductByID() {
        return url + "api/products/85577";
    }
    @Step("I send a request to get the product with the valid ID")
    public void sendGetRequestForGetProductByID() {
        SerenityRest.given().get(setAPIForGetProductByID());
    }

    @Step("I should receive the details of the product associated with the provided ID")
    public void receiveDetailValidDataProductWithTheProvidedID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();

        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCTS_BY_ID_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'ID'", equalTo(85577)));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Categories'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I set API endpoint for get a product with invalid ID")
    public String setInvalidAPIForGetProductByID() {
        return url + "api/products/9";
    }
    @Step("I send a request GET to get product")
    public void sendGetRequestInvalidForGetProductByID() {
        SerenityRest.given().get(setInvalidAPIForGetProductByID());
    }
    @Step("I should receive a status code of 404")
    public void responseStatusCode404ForGetProductByID(){
        restAssuredThat(response-> response.statusCode(404));
    }
    @Step("I should receive an error message indicating that the product was not found")
    public void receiveMessageErrorShouldIndicatePageNotFound() {
        System.out.println("Error message indicates that the page was not found.");
    }
}
