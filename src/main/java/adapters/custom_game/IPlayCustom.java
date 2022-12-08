package adapters.custom_game;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutputBoundary;
import user_interface.login_leaderboard.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IPlayCustom extends ActionListener {

    @Override
    void actionPerformed(ActionEvent e);

    default void getMazeInteractor(String file) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(file);

        IGamePanelOutputBoundary presenter = new GamePanelPresenter();
        IFileOutputBoundary output = new FileWriter();
        MazeInteractor maze = new MazeInteractor(presenter, output);
        maze.load("custom_mazes/" + file);
        maze.startGameThread();
        GamePanelController controller = new GamePanelController(maze);

        window.add((Component) presenter);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addKeyListener(controller);
        window.setFocusable(true);
    }
}
