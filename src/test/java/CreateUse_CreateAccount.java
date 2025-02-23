import org.credobank.testautomation.CssClientRegistration.CallsAndSteps.CreateAccount.CreateUserWithAccount;
import org.testng.annotations.Test;

public class CreateUse_CreateAccount {

    @Test
    public void createUserAndAccount() {
        CreateUserWithAccount createUserWithAccount = new CreateUserWithAccount();
        createUserWithAccount.CreateAccount("76003");
    }
}
