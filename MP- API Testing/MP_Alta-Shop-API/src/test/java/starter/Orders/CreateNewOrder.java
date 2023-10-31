package starter.Orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewOrder {
    private static String url = "https://altashop-api.fly.dev/";

    @Step("I set API for create new orders")
    public String setApiEndpointCreateNewOrder() {
        return url + "api/orders";
    }
    @Step("I send request for create new order")
    public void sendCreateNewOrder() {
        JSONArray orderRequestBody = new JSONArray();

        JSONObject requestBody = new JSONObject();

        requestBody.put("product_id", 2);
        requestBody.put("quantity", 1);
        orderRequestBody.put(0, requestBody);
        System.out.println(orderRequestBody);

        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(orderRequestBody.toString())
                .post(setApiEndpointCreateNewOrder());
    }
    @Step("I receive valid data for create new order")
    public void receiveValidDataForCreateNewOrder() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ORDER_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I send request with required input")
    public void sendCreateNewOrderWithRequiredInputs() {
        JSONArray orderRequestBody = new JSONArray();

        JSONObject requestBody = new JSONObject();

        requestBody.put("product_id", "");
        requestBody.put("quantity", "");
        orderRequestBody.put(0, requestBody);
        System.out.println(orderRequestBody);

        String data = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(orderRequestBody.toString())
                .post(setApiEndpointCreateNewOrder());
    }

}
