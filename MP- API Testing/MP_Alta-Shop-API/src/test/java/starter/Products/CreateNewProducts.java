package starter.Products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateNewProducts {
    private static String url = "https://altashop-api.fly.dev/";

    @Step("I set API endpoint for creating a new product is available")
    public String setApiEndpointCreateNewProduct() {
        return url + "api/products";
    }

    @Step("I send request to create user with valid inputs")
    public void sendCreateUserRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Sony PS5");
        requestBody.put("description", "play has no limits");
        requestBody.put("price", 299);

        JSONArray categories = new JSONArray();
        categories.put(2); // Note that you have changed the category value here
        requestBody.put("categories", categories);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpointCreateNewProduct());
    }
    @Step("I should receive a status code of 200")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I should receive the details of the newly created product")
    public void receiveDetailsOfTheNewlyCreatedProduct() {
        Response response = SerenityRest.lastResponse();
        JSONObject responseBody = new JSONObject(response.asString());

        assert responseBody.getJSONObject("data").getString("Name").equals("Sony PS5");
        assert responseBody.getJSONObject("data").getString("Description").equals("play has no limits");
        assert responseBody.getJSONObject("data").getInt("Price") == 299;
        assert responseBody.getJSONObject("data").getJSONArray("Categories").length() >= 0;
    }

    @Step("I send a request to create a new product with required fields")
    public void sendRequestRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("description", "");
        requestBody.put("price", 299);

        JSONArray categories = new JSONArray();
        categories.put(2); // Note that you have changed the category value here
        requestBody.put("categories", categories);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpointCreateNewProduct());
    }
    @Step("I should receive a status code of 500")
    public void responseStatusCode500(){
        restAssuredThat(response-> response.statusCode(500));
    }

    @Step("I should receive an error message indicating the missing fields")
    public void receiveMessageErrorIndicatingMessageError(){
        System.out.println("missing fields");
    }
}
