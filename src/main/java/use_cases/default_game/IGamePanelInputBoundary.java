package use_cases.default_game;

/**
 * The input boundary that is implemented by the use case interactor UpdatePlayer.
 */
public interface IGamePanelInputBoundary {

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input
     */
    void movePlayer(int keycode);
    /**
     * Update maze components.
     * For example, moving enemies will move when this is called.
     */
    void update();
}
