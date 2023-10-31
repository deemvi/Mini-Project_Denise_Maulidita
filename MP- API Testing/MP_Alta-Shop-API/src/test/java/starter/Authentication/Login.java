package starter.Authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Login {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint for login")
    public String setApiEndpoint() {
        return url + "auth/login";
    }

    @Step("I send request to login with valid email {string} and valid password {string}")
    public void sendLoginRequest(String email, String password) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }


    @Step("I receive valid data for login")
    public void receiveValidDataForLogin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I send request to login with unregistered email {string} and valid password {string}")
    public void sendLoginRequestWithUnregisteredCredentials(String email, String password) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive message error")
    public void receiveMessageError() {
        System.out.println("400 : Bad Request");
    }
}