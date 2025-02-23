package org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateAccount;

import org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateUser.CreateUser;
import org.credobank.testautomation.CssClientRegistration.DataController;
import org.credobank.testautomation.CssClientRegistration.Models.CreateCurrentAccount.CreateAccountResponseModel;
import org.credobank.testautomation.CssClientRegistration.Models.CreateUser.CreatePersonResponseModel;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class CreateUserWithAccount {
    DataController dataController = new DataController();
    CreateAccount_Steps createAccountSteps = new CreateAccount_Steps();
    String token = "";

    public CreateAccountResponseModel CreateAccount(String channel) {
        CreateAccountResponseModel createAccountResponseModel = new CreateAccountResponseModel();
        try {
            CreateUser createUser = new CreateUser();
            CreatePersonResponseModel createPersonResponseModel = createUser.Create(channel);
            String jsonString = Files.readString(Path.of("C:/Users/tinatingvelesiani/IdeaProjects/CssClientRegistration/src/main/java/org/credobank/testautomation/CssClientRegistration/Data/CreateAccount/AccountRequest.json"));
            JSONObject jsonObject = new JSONObject(jsonString);
            token = dataController.GetAccessToken();
            jsonObject.put("personId", createPersonResponseModel.getResult().getId());
            createAccountResponseModel = createAccountSteps.CreateAccount(jsonObject, token.split(" ")[1]);
        } catch (SQLException | IOException e) {
            createAccountResponseModel.setError(e.toString());
            throw new RuntimeException(e);
        }
        return createAccountResponseModel;
    }
}