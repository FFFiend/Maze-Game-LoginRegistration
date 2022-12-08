package leaderboard;
import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import org.junit.jupiter.api.Test;
import use_cases.login_leaderboard.*;
import frameworks_and_drivers.login_leaderboard.FileReader;
import frameworks_and_drivers.login_leaderboard.FileWriter;

public class ControllersTest {

    /**
     * Tests various use cases in bulk, breadth and depth of each simultaneously.
     * Goes over different user and login scenarios and checks whether the appropriate message
     * is being displayed for each.
     */
    @Test
    public void LoginUserControllerTest() {
        // Set up the framework for login
        ILoginUserOutputBoundary output = new LoginUserPresenter();
        LoginUser loginUseCase = new LoginUser(output);
        loginUseCase.setUsers(FileReader.create().PREV.getUsers());
        LoginUserController logincontroller = new LoginUserController(loginUseCase);


        Assertions.assertEquals("no",logincontroller.performUseCase("abc","hello"));
        Assertions.assertEquals("no",logincontroller.performUseCase("abc","ha"));
        Assertions.assertEquals("no",logincontroller.performUseCase("Sean","hello"));
    }


    @Test
    public void RegisterUserControllerTest() {
        // Set up the framework for register
        IRegisterUserOutputBoundary regoutput = new RegisterUserPresenter();
        IFileOutputBoundary dataOutput = new FileWriter();
        RegisterUser registerUseCase = new RegisterUser(regoutput, dataOutput);
        registerUseCase.setUsers(FileReader.create().PREV.getUsers());
        RegisterUserController regcontroller = new RegisterUserController(registerUseCase);

       Assertions.assertEquals("no", regcontroller.performUseCase("Rob","a@gmail.com",
                "abc"));

       Assertions.assertEquals("user exists", regcontroller.performUseCase("abc","a@gmail.com",
                "Owais.93"));

       Assertions.assertEquals("user exists", regcontroller.performUseCase("Owais","a@gmail.com",
                "Owais.93"));

        Assertions.assertEquals("user exists", regcontroller.performUseCase("Bob","bob@gmail.com",
                "Bob.1234"));
    }
}