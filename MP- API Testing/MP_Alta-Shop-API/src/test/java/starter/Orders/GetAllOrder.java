package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrder {
    private static String url = "https://altashop-api.fly.dev/";

    @Step("I set API endpoint for get all order")
    public String setApiEndpointGetAllOrder() {
        return url + "api/orders";
    }

    @Step("I send GET request to the endpoint to get all order")
    public void sendGetAllOrderRequest() {
        String data = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + data)
                .header("Content-Type", "application/json")
                .get(setApiEndpointGetAllOrder());

    }

    @Step("I receive valid data for get all order")
    public void receiveValidDataForGetAllOrder() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDER_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set invalid API endpoint for get all order with invalid parameters")
    public String setInvalidAPIForGetAllOrder() {
        return url + "api/ord";
    }

    @Step("I send GET request for get all order")
    public void sendGetRequestForGetAllOrder() {
        SerenityRest.given().get(setInvalidAPIForGetAllOrder());
    }
}
