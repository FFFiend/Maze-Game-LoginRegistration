package user_interface.login_leaderboard;

import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.login_leaderboard.*;

import javax.swing.*;
import java.util.Objects;

public class PanelManager {

        public Panel getNextPanel(String nextPanel,Panel currPanel) {
            if (Objects.equals(nextPanel, "Sign up")) {
                IRegisterUserOutputBoundary output = new RegisterUserPresenter();
                RegisterUser registerUseCase = new RegisterUser(output);
                registerUseCase.setUsers(FileReader.create().PREV.getUsers());

                RegisterUserController controller = new RegisterUserController(registerUseCase);

                return new RegisterPanel(controller);
            }
            // sign up is a dead end, user must restart and log in to play the game.

            else if(Objects.equals(nextPanel, "Log in")){
                ILoginUserOutputBoundary output = new LoginUserPresenter();
                LoginUser loginUseCase = new LoginUser(output);
                loginUseCase.setUsers(FileReader.create().PREV.getUsers());

                LoginUserController controller = new LoginUserController(loginUseCase);

                return new LoginPanel(controller,currPanel.outputBoundary);
            }
            else if(Objects.equals(nextPanel, "Home Panel Launch")){
                // return home panel;

                return new HomePanel(currPanel.outputBoundary);

            }
            else if(Objects.equals(nextPanel, "MAIN GAME")){
                // return game panel;


            }
            else if(Objects.equals(nextPanel, "CUSTOM GAME")){
                // return custom game panel

            }
            else if(Objects.equals(nextPanel, "VIEW LEADERBOARD")){
                // return leaderboard screen

            }
            return null;
        }
}
