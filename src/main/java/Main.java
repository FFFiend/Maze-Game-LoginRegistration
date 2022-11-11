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
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGamePanel() {
        GamePanelUI gamePanelUI = new GamePanelUI();
        gamePanelUI.createGamePanelUI();
    }
}
