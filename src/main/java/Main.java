import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
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
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGame() {
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setWelcomePanel();
        tempDefaultGameRunner();
    }

    /**
     * Temporary access to the custom maze editor and the file manager's storage functionality
     **/
    private static void tempEditorRunner() {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel("CustomGameEditorPanel");
    }
    /**
     * Temporary access to the default game
     **/
    private static void tempDefaultGameRunner(){
        GamePanel gamePanelUI = new GamePanel();
        gamePanelUI.createGamePanel();
    }
}
