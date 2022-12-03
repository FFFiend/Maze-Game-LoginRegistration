package use_cases.default_game;

import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

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

    /**
     * Set the game state.
     *
     * @param newState The new game state. This must be one of the *_STATE constants defined above.
     */
    void changeState(int newState);

    void recordStamina(int stamina);
}
