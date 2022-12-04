package use_cases.default_game;

/**
 * The output boundary implemented by GamePanelPresenter.
 */
public interface IGamePanelOutputBoundary {

    /**
     * Update maze information and draw it accordingly.
     */
    void redrawMaze(MazeInteractor maze);

    int TITLE_STATE = 0;
    int PLAY_STATE = 1;
    int LEVEL_CLEAR_STATE = 2;
    int GAME_OVER_STATE = 3;

    /**
     * Set the game state.
     *
     * @param newState The new game state. This must be one of the *_STATE
     *                 constants defined in IGameOutputBoundary.
     */
    void changeState(int newState);

    /**
     * Record the current stamina.
     *
     * @param stamina current stamina
     */
    void recordStamina(int stamina);

    int getState();
}
