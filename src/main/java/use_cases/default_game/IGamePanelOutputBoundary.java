package use_cases.default_game;

/**
 * The output boundary implemented by GamePanelPresenter.
 */
public interface IGamePanelOutputBoundary {

    /**
     * Update the player position and draw the maze accordingly.
     *
     * @param playerX player position X
     * @param playerY player position Y
     */
    default void updateMaze(int playerX, int playerY) {
    }
}
