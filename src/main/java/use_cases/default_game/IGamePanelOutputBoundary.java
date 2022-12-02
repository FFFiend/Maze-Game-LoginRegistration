package use_cases.default_game;

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
    void updateMaze(int playerX, int playerY, int playerStamina);
}
