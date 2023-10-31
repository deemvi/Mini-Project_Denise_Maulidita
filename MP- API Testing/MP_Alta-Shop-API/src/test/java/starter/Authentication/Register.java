package starter.Authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.FileUtils;
import starter.utils.FileUtils2;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class Register {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint for register")
    public String setApiEndpoint() {
        return url + "auth/register";
    }

    @Step("I send request to register")
    public void sendRegisterRequest() {
        JSONObject requestBody = FileUtils.getUser();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }
    @Step("I receive status code 200 for register")
    public void receiveStatusCode200ForRegister() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for register")
    public void receiveValidRegisterData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_RESPONSE_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Password'", notNullValue()));
  restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a request with existing email")
    public void sendRegisterRequestWithExistingEMail() {
        JSONObject requestBody = FileUtils2.getUser2();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }
    @Step("I should receive a status code of 400")
    public void shouldReceiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I receive an error message indicating duplicate key value")
    public void receiveMessageErrorIndicatingDuplicateKeyValue() {
        System.out.println("ERROR: duplicate key value violates unique constraint \\\"users_email_key\\\" (SQLSTATE 23505)");
    }
}
