package frameworks_and_drivers.default_game;

import adapters.default_game.GamePanelPresenter;
import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.RegisterUserController;
import frameworks_and_drivers.custom_game.custom_game_panels.CustomGamePresenter;
import frameworks_and_drivers.login_leaderboard.*;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

/**
 * A class that manages panel switching within the Global Frame.
 */
public class PanelManager {
    private static final Dictionary<String, Object> dict = new Hashtable<>();
    private LoginPanel login;
    private RegisterPanel register;

    /**
     * Assign the given object to the string.
     *
     * @param objectName name of the given Class
     * @param object class
     */
    public static void assign(String objectName, Object object) {
        dict.put(objectName, object);
    }

    /**
     * This method implements the panel switching and incorporates the Clean Architecture
     * program flow into it.
     *
     * @param nextPanel a string that determines what panel is to be generated and
     *                  switched to.
     * @param currPanel the current panel.
     * @return the panel to be switched to.
     */
    public JPanel getNextPanel(String nextPanel, Panel currPanel) {
        if (Objects.equals(nextPanel, "Sign up")) {
            RegisterUserController controller = (RegisterUserController) dict.get(
                    "RegisterUserController");
            register = new RegisterPanel(controller, currPanel.outputBoundary);
            return register;

        } else if (Objects.equals(nextPanel, "Log in") || Objects.equals(nextPanel, "Reg Log in")) {
            LoginUserController controller = (LoginUserController) dict.get("LoginUserController");
            login = new LoginPanel(controller, currPanel.outputBoundary);
            return login;

        } else if (Objects.equals(nextPanel, "Home Panel Launch") || Objects.equals(nextPanel, "Registered")) {
            if (Objects.equals(nextPanel, "Registered")) {
                FileWriter.username = register.getUsername();
            } else {
                FileWriter.username = login.getUsername();
            }
            return new HomePanel(currPanel.outputBoundary);

        } else if (Objects.equals(nextPanel, "MAIN GAME")) {
            return (GamePanelPresenter) dict.get("GamePanelPresenter");

        } else if (Objects.equals(nextPanel, "CUSTOM GAME")) {

            CustomGamePresenter tempPresenter = new CustomGamePresenter();
            tempPresenter.callCustomGamePanel();

        } else if (Objects.equals(nextPanel, "VIEW LEADERBOARD")) {
            // return leaderboard screen
            return new LeaderboardsPanel(currPanel.outputBoundary);

        } else if (Objects.equals(nextPanel, "wipe out")) {
            return new WelcomeGlobalFrame(currPanel.outputBoundary);
        }

        return null;
    }
}