package use_cases.default_game;

/**
 * The input boundary that is implemented by the use case interactor UpdatePlayer.
 */
public interface IGamePanelInputBoundary {

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input W,A,S,D
     */
    void movePlayer(int keycode);

    /**
     * Reset the state of the maze.
     */
    void reset();

    /**
     * Display the maze level that the user selected
     *
     * @param keycode the keyboard input 1,2,3
     */
    void displayLevel(int keycode);
}
