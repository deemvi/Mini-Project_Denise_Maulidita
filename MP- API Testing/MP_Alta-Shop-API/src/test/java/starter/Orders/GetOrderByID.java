package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderByID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint for get a order by ID")
    public String setApiEndpointGetOrderByID() {
        return url + "orders/12358";
    }

    @Step("I send a request to get the order with the valid ID")
    public void sendGetOrderByID() {
        String data = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .get(setApiEndpointGetOrderByID());
    }

    @Step("I should receive the details of the order associated with the provided ID")
    public void receiveValidDataForGetOrderByID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDER_BY_ID_SCHEMA);

        restAssuredThat(response->response.body("'data'.'ID'", equalTo(12358)));
        restAssuredThat(response->response.body("'data'.'User'", notNullValue()));
        restAssuredThat(response->response.body("'data'.'Product'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get a order with invalid ID")
    public String setInvalidIDForGetOrderByID() {
        return url + "or0";
    }

    @Step("I send a request GET to get order by id")
    public void sendGetRequestForGetOrderByID() {
        SerenityRest.given().get(setInvalidIDForGetOrderByID());
    }
}
