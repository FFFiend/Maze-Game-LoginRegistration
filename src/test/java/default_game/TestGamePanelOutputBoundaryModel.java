package default_game;

import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;

/**
 * an IGamePanelOutputBoundary implementation for testing only
 */
public class TestGamePanelOutputBoundaryModel implements IGamePanelOutputBoundary {
    @Override
    public void redrawMaze(MazeInteractor maze) {
    }

    @Override
    public void changeState(int newState) {
    }

    @Override
    public void recordStamina(int stamina) {
    }

    @Override
    public int getState() {
        return 1;
    }

}
