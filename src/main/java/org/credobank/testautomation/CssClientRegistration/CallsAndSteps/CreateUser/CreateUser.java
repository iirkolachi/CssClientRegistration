package org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateUser;

import org.credobank.testautomation.CssClientRegistration.DataController;
import org.credobank.testautomation.CssClientRegistration.Models.CreateUser.CreatePersonResponseModel;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class CreateUser {
    DataController dataController = new DataController();
    CssCreatePerson_Steps cssCreatePersonSteps = new CssCreatePerson_Steps();
    String token = "";
    CreatePersonResponseModel createPersonResponseModel = new CreatePersonResponseModel();

    public CreatePersonResponseModel Create(String channel) {
        try {
            String jsonString = Files.readString(Path.of("C:/Users/tinatingvelesiani/IdeaProjects/CssClientRegistration/src/main/java/org/credobank/testautomation/CssClientRegistration/Data/CreateUser/largeFile.json"));
            JSONObject jsonObject = new JSONObject(jsonString);
            token = dataController.GetAccessToken();
            String phoneNumber = dataController.GenerateRandomPhone();
            String personalNumber = dataController.GenerateRandomPersonalNumber();
            jsonObject.put("Mobile", phoneNumber);
            jsonObject.put("PersonalN", personalNumber);
            jsonObject.put("ChannelTypeId", channel);
            jsonObject.put("ChannelId", channel);
            createPersonResponseModel = cssCreatePersonSteps.CreatePerson(jsonObject, token.split(" ")[1]);
        } catch (SQLException | IOException e) {
            createPersonResponseModel.setError(e.toString());
            throw new RuntimeException(e);
        }
        return createPersonResponseModel;
    }
}