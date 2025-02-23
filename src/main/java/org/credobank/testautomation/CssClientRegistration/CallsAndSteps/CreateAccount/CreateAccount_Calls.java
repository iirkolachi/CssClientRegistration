package org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class CreateAccount_Calls {
    public Response response(JSONObject jsonObject, String accessToken) throws JsonProcessingException {
        //jsonObject  =   new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(cardTransactionRequestModel);
        JSONObject indexObject = new JSONObject();
        return given()
                .header("Authorization","Bearer " + accessToken )
                .header("Accept" , "*/*")
                .header("Accept-Encoding" , "gzip, deflate, br")
                .contentType("application/json; charset=utf-8")
                .when()
                .body(jsonObject.toString())
                .post("http://test.api.css.credo.ge/api/Account/MultyCurrencyCurrentAccountRegistration");
    }
}