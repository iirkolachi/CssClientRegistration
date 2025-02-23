package org.credobank.testautomation.CssClientRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DataController {
    String query_checkPersonalNumber = """
            IF EXISTS (
                SELECT TOP 1 *
                FROM CredoBnk.dbo.TBL_Person (NOLOCK) AS a
                WHERE a.PersonalN = ?
            )
            BEGIN
                SELECT 1 AS result
            END
            ELSE
            BEGIN
                SELECT 0 AS result
            END
            """;

    String query_checkPhone = """
            IF EXISTS (
                SELECT
            	TOP 1 *
                FROM CredoBnk.person.Contact (NOLOCK) AS a
                WHERE a.Contact LIKE ? AND a.ContactTypeId = 29792
            )
            BEGIN
            	SELECT 1 AS result
            END
            ELSE
            BEGIN
            	SELECT 0 AS result
            END
            """;

    String query_getToken = """
            EXEC CredoBnk.dbo.GetSystemAuthorizationToken
            """;


    //generate token
    public String GetAccessToken() throws SQLException {
        Connection databaseAccessSQL = DataBaseAccessSQL.getInstanceCss();
        ResultSet result = null;
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getToken);
        String token = "";
        result = preparedStatement.executeQuery();
        while (result.next()) {
            token = result.getString("Token");
        }
        return token;
    }

    //generate and check phone number
    public String GenerateRandomPhone() throws SQLException {
        Random random = new Random();
        String phoneNumber = "";
        for (int i = 0; i < 10; i++) {
            int index = 557;
            int randomNumber = random.nextInt(100000, 999999);
            phoneNumber = String.valueOf(index) + String.valueOf(randomNumber);
            if(!CheckPhone(query_checkPhone)) {
                break;
            }
        }
        return phoneNumber;
    }
    boolean CheckPhone(String phoneNumber) throws SQLException {
        Connection databaseAccessSQL = DataBaseAccessSQL.getInstanceCss();
        ResultSet result = null;
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_checkPhone);
        preparedStatement.setString(1, phoneNumber);
        boolean phoneExists = false;
        result = preparedStatement.executeQuery();
        while (result.next()) {
            if(result.getString("result").equals("0")){
                phoneExists = false;
            } else phoneExists = true;
        }
        return phoneExists;
    }

    //generate and check personalNumber
    public String GenerateRandomPersonalNumber() throws SQLException {
        Random random = new Random();
        String personalNumber = "";
        for (int i = 0; i < 10; i++) {
            long randomPersonalN = random.nextLong(10000000000L, 99999999999L);
            personalNumber = String.valueOf(randomPersonalN);
            if(!CheckPersonalNumber(query_checkPersonalNumber)) {
                break;
            }
        }
        return personalNumber;
    }

    boolean CheckPersonalNumber(String personalNumber) throws SQLException {
        Connection databaseAccessSQL = DataBaseAccessSQL.getInstanceCss();
        ResultSet result = null;
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_checkPersonalNumber);
        preparedStatement.setString(1, personalNumber);
        boolean personalNumberExists = false;
        result = preparedStatement.executeQuery();
        while (result.next()) {
            if(result.getString("result").equals("0")){
                personalNumberExists = false;
            } else personalNumberExists= true;
        }
        return personalNumberExists;
    }
}
