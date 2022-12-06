package user_interface.login_leaderboard;

import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.login_leaderboard.*;

import javax.swing.*;
import java.util.Objects;

/**
 * A class that manages panel switching within the Global Frame.
 */
public class PanelManager {

    /**
     * This method implements the panel switching and incorporates the Clean Architecture
     * program flow into it.
     * @param nextPanel a string that determines what panel is to be generated and
     *                  switched to.
     * @param currPanel the current panel.
     * @return the panel to be switched to.
     */
        public Panel getNextPanel(String nextPanel,Panel currPanel) {
            if (Objects.equals(nextPanel, "Sign up")) {
                IRegisterUserOutputBoundary output = new RegisterUserPresenter();
                RegisterUser registerUseCase = new RegisterUser(output);
                registerUseCase.setUsers(FileReader.create().PREV.getUsers());

                RegisterUserController controller = new RegisterUserController(registerUseCase);

                return new RegisterPanel(controller, currPanel.outputBoundary);
            }
            // sign up is a dead end, user must restart and log in to play the game.

            else if(Objects.equals(nextPanel, "Log in") || Objects.equals(nextPanel, "Reg Log in")){
                ILoginUserOutputBoundary output = new LoginUserPresenter();
                LoginUser loginUseCase = new LoginUser(output);
                loginUseCase.setUsers(FileReader.create().PREV.getUsers());

                LoginUserController controller = new LoginUserController(loginUseCase);

                return new LoginPanel(controller,currPanel.outputBoundary);
            }
            else if(Objects.equals(nextPanel, "Home Panel Launch")){
                return new HomePanel(currPanel.outputBoundary);

            }
            // General Instructions to Incorporate your respective UI's:
            // Have your panels extend the Panels class IF POSSIBLE, and pass in an
            // IGlobalFrameOutputBoundary object into the constructor, and set the
            // attribute to the same.
            // Otherwise, just declare the attribute IGlobalFrameOutputBoundary ob within your
            // respective classes, and set it within the constructor.

            // Next, migrate the UI initialization part of your use cases into your
            // respective else-if case blocks below, and simply return the Presenter/Panel
            // like above on line 47.
            else if(Objects.equals(nextPanel, "MAIN GAME")){
                // return game panel;

            }
            else if(Objects.equals(nextPanel, "CUSTOM GAME")){
                // return custom game panel

            }
            else if(Objects.equals(nextPanel, "VIEW LEADERBOARD")){
                // return leaderboard screen
                return new LeaderboardsPanel(currPanel.outputBoundary);

            }
            return null;
        }
}
