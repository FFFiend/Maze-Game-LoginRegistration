package use_cases.custom_game.custom_game_file_management;

import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IPLayCustom extends ActionListener {

    @Override
    void actionPerformed(ActionEvent e);

    default MazeInteractor getMazeInteractor(IGamePanelOutputBoundary presenter, String file) {
        MazeInteractor maze = new MazeInteractor(presenter);
        maze.load(file);
        maze.startGameThread();
        return maze;
    }
}
