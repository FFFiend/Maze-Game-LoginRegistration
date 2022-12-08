package leaderboard;
import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_cases.login_leaderboard.ILoginUserOutputBoundary;
import use_cases.login_leaderboard.IRegisterUserOutputBoundary;
import use_cases.login_leaderboard.LoginUser;
import use_cases.login_leaderboard.RegisterUser;
import user_interface.login_leaderboard.FileReader;

public class ControllersTest {

    /**
     * Tests various use cases in bulk, breadth and depth of each simultaneously.
     * Goes over different user and login scenarios and checks whether the appropriate message
     * is being displayed for each.
     */
    @Test
    public void LoginUserControllerTest(){
        ILoginUserOutputBoundary output = new LoginUserPresenter();
        LoginUser loginUseCase = new LoginUser(output);
        LoginUserController logincontroller = new LoginUserController(loginUseCase);
        loginUseCase.setUsers(FileReader.create().PREV.getUsers());

        Assertions.assertEquals("yes",logincontroller.performUseCase("abc","hello"));
        Assertions.assertEquals("no",logincontroller.performUseCase("abc","ha"));
        Assertions.assertEquals("no",logincontroller.performUseCase("Sean","hello"));


        IRegisterUserOutputBoundary regoutput = new RegisterUserPresenter();
        RegisterUser registerUseCase = new RegisterUser(regoutput);
        registerUseCase.setUsers(FileReader.create().PREV.getUsers());


        RegisterUserController regcontroller = new RegisterUserController(registerUseCase);
        Assertions.assertEquals("no",regcontroller.performUseCase("Rob","a@gmail.com",
                "abc"));

        Assertions.assertEquals("yes",regcontroller.performUseCase("abc","a@gmail.com",
                "abcdG4$f"));

        Assertions.assertEquals("yes",regcontroller.performUseCase("Owais","a@gmail.com",
                "abcdG4$f"));

        Assertions.assertEquals("no",regcontroller.performUseCase("Owais","amail.com",
                "abcdG4$f"));
    }
}
