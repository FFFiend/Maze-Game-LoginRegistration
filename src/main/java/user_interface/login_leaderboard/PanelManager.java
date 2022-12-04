package user_interface.login_leaderboard;

import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.login_leaderboard.*;

import java.util.Objects;

public class PanelManager {

        public Panel getNextPanel(String nextPanel) {
        if (Objects.equals(nextPanel, "Sign up")) {
            IRegisterUserOutputBoundary output = new RegisterUserPresenter();
            RegisterUser registerUseCase = new RegisterUser(output);
            registerUseCase.setUsers(FileReader.create().PREV.getUsers());

            RegisterUserController controller = new RegisterUserController(registerUseCase);
            RegisterPanel register = new RegisterPanel(controller);

            return register;
        }
        else if(Objects.equals(nextPanel, "Log in")){
            ILoginUserOutputBoundary output = new LoginUserPresenter();
            LoginUser loginUseCase = new LoginUser(output);
            loginUseCase.setUsers(FileReader.create().PREV.getUsers());

            LoginUserController controller = new LoginUserController(loginUseCase);
            LoginPanel login =  new LoginPanel(controller);

            return login;
        }
        // add all panels here
        return null;
    }
}
