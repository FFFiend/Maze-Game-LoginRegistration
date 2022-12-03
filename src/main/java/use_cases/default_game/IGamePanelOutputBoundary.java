package use_cases.default_game;

import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

/**
 * The output boundary implemented by GamePanelPresenter.
 */
public interface IGamePanelOutputBoundary {

    /**
     * Update player information and draw the maze accordingly.
     *
     * @param playerX       player position X
     * @param playerY       player position Y
     * @param playerStamina player stamina
     */
    void redrawMaze(MazeInteractor maze);

    void changeState();

    void recordStamina(int stamina);
}
