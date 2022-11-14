import user_interface.custom_game.custom_game_screens.CustomGamePresenter;
import user_interface.default_game.GamePanelUI;

/**
 * Run the game
 **/
public class Main {
    /**
     * Run this method to run the game panel
     *
     * @param args for when we need some input
     */
    public static void main(String[] args) {
        setupGamePanel();
        tempEditorRunner();
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGamePanel() {
        GamePanelUI gamePanelUI = new GamePanelUI();
        gamePanelUI.createGamePanelUI();
    }

    private static void tempEditorRunner() {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGameScreen("CustomGameEditorScreen");
    }
}
