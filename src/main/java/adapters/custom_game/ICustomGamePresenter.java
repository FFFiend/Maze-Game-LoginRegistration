package adapters.custom_game;

/**
 * Handles switching between custom maze UI panels
 */
public interface ICustomGamePresenter {

    void callCustomGamePanel();

    void callCustomGamePanel(String panelName);

    void callCustomPopup(String message, String panel);

    void callCustomPopup(String message);

    void refocusEditor();
}
