package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.ICustomGamePresenter;

import java.util.Objects;

/**
 * Handles switching between custom maze UI panels
 */
public class CustomGamePresenter implements ICustomGamePresenter, ICustomGamePanel {

    /**
     * Call the constructors of one of the custom game panels
     */
    public void callCustomGamePanel(String panelName) {
        if (Objects.equals(panelName, "CustomGameMainPanel")) {
            new CustomGameMainPanel();
        }
        else if (Objects.equals(panelName, "CustomGameInitializerPanel")) {
            new CustomGameInitializerPanel();
        }
        else if (Objects.equals(panelName, "CustomGameEditorPanel")) {
            new CustomGameEditorPanel();
        }
        else {
            System.out.println("To do!");
            //TODO throw an error
        }
    }

    /**
     * Overloaded version of the above method allowing the main custom game panel to be the default should no parameter
     * be provided
     */
    public void callCustomGamePanel() {
        new CustomGameMainPanel();
    }

    /**
     * Displays a popup informing the user that one of their inputs was invalid
     *
     * @param message the message to display
     * @param panel the panel to go back to if the user wants to fix the invalid input
     */
    public void callCustomPopup(String message, String panel) {
        new CustomGamePopup(message, panel);
    }

    /**
     * Displays a popup informing the user of something other than invalid input
     *
     * @param message the message to display
     */
    public void callCustomPopup(String message) {
        new CustomGamePopup(message);
    }
}