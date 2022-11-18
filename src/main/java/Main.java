import adapters.custom_game.custom_game_file_adapters.TempMaze;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;
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
    }

    /**
     * Temporary access to the custom maze editor and the file manager's storage functionality
     **/
    private static void tempEditorRunner() {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel("CustomGameEditorPanel");

        TempMaze.getTile(0, 0).changeState("end");
        TempMaze.getTile(0, 1).changeState("photons");
        TempMaze.getTile(3, 4).changeState("enemy");
        TempMaze.getTile(11, 15).changeState("start");

        CustomGameFileManager fileManager = new CustomGameFileManager();
        fileManager.storeNewCustomMaze();

    }
}
