package org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateUser;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.credobank.testautomation.CssClientRegistration.Models.CreateUser.CreatePersonResponseModel;
import org.json.JSONObject;

public class CssCreatePerson_Steps {
    public CreatePersonResponseModel CreatePerson(JSONObject jsonObject, String accessToken) throws JsonProcessingException {
        CssCreatePerson_Calls createPerson_calls = new CssCreatePerson_Calls();
        Response applicationResponse = createPerson_calls.response(jsonObject, accessToken);
        System.out.println(applicationResponse.asPrettyString());
        int statusCode = applicationResponse.getStatusCode();
        CreatePersonResponseModel createPersonResponseModel = null;
        if (statusCode == 200) {
            createPersonResponseModel = applicationResponse.as(CreatePersonResponseModel.class);
        } else {
            createPersonResponseModel = new CreatePersonResponseModel();
            createPersonResponseModel.setError(String.format("Error occurred: Status code %d, Response: %s", statusCode, applicationResponse.getBody()));
        }
        return createPersonResponseModel;
    }
}
