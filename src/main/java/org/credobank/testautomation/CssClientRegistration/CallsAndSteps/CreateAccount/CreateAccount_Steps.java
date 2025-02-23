package org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.credobank.testautomation.CssClientRegistration.Models.CreateCurrentAccount.CreateAccountResponseModel;
import org.json.JSONObject;

public class CreateAccount_Steps {
    public CreateAccountResponseModel CreateAccount(JSONObject jsonObject, String accessToken) throws JsonProcessingException {
        CreateAccount_Calls createAccountCalls = new CreateAccount_Calls();
        Response applicationResponse = createAccountCalls.response(jsonObject, accessToken);
        System.out.println(applicationResponse.asPrettyString());
        int statusCode = applicationResponse.getStatusCode();
        CreateAccountResponseModel createAccountResponseModel = null;
        if (statusCode == 200) {
            createAccountResponseModel = applicationResponse.as(CreateAccountResponseModel.class);
        } else {
            createAccountResponseModel = new CreateAccountResponseModel();
            createAccountResponseModel.setError(String.format("Error occurred: Status code %d, Response: %s", statusCode, applicationResponse.getBody()));
        }
        return createAccountResponseModel;
    }
}
