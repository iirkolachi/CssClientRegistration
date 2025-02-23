import org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateAccount.CreateUserWithAccount;
import org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateUser.CreateUser;
import org.credobank.testautomation.CssClientRegistration.DataController;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class testMethods {

    @Test
    public void testRandomPhoneNumber() throws SQLException {
        DataController dataController = new DataController();
        System.out.println(dataController.GenerateRandomPhone());
    }

    @Test
    public void testRandomPersonalNumber() throws SQLException {
        DataController dataController = new DataController();
        System.out.println(dataController.GenerateRandomPersonalNumber());
    }

    @Test
    public void testCreatePerson() {
        CreateUser createUser = new CreateUser();
        createUser.Create("76003");
    }

    @Test
    public void testCreateUserWithAccount() {
        CreateUserWithAccount createUserWithAccount = new CreateUserWithAccount();
        createUserWithAccount.CreateAccount("76003");
    }
}
