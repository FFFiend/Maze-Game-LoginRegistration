import user_interface.custom_game.custom_game_screens.CustomGamePresenter;
import user_interface.default_game.GamePanelUI;
import user_interface.default_game.GlobalFrame;

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
        setupGame();
        tempEditorRunner();
        tempDefaultGameRunner();
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGame() {
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setWelcomePanel();
    }

    /**
     * Temporary access to the custom maze editor
     **/
    private static void tempEditorRunner() {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGameScreen("CustomGameEditorScreen");
    }
    /**
     * Temporary access to the default game
     **/
    private static void tempDefaultGameRunner(){
        GamePanelUI gamePanelUI = new GamePanelUI();
        gamePanelUI.createGamePanelUI();
    }
}
