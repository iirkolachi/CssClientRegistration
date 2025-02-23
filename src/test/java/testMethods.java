import org.credobank.testautomation.CssClientRegistration.DataControllerCreateUser;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class testMethods {

    @Test
    public void testRandomPhoneNumber() throws SQLException {
        DataControllerCreateUser dataControllerCreateUser = new DataControllerCreateUser();
        System.out.println(dataControllerCreateUser.GenerateRandomPhone());
    }

    @Test
    public void testRandomPersonalNumber() throws SQLException {
        DataControllerCreateUser dataControllerCreateUser = new DataControllerCreateUser();
        System.out.println(dataControllerCreateUser.GenerateRandomPersonalNumber());
    }
}
