package user_interface.login_leaderboard;

import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.login_leaderboard.IRegisterUserInputBoundary;
import use_cases.login_leaderboard.IRegisterUserOutputBoundary;
import use_cases.login_leaderboard.RegisterUser;

public class StateManager {

    // current panel  welcome
    // 0 -> sign up
    // 1 -> log in

    // welcome screen ->
    public Panel getNextPanel(int i) {
        if (i == 0) {
            IRegisterUserOutputBoundary output = new RegisterUserPresenter();
            RegisterUser registerUseCase = new RegisterUser(output);
            registerUseCase.setUsers(FileReader.create().PREV.getUsers());

            RegisterUserController controller = new RegisterUserController(registerUseCase);
            RegisterPanel register = new RegisterPanel(controller);

            return register;
        }

        return null;
    }
    public Panel getCurrPanel(){
        return null;
    }
}
