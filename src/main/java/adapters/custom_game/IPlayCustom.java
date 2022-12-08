package adapters.custom_game;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutputBoundary;
import frameworks_and_drivers.login_leaderboard.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IPlayCustom extends ActionListener {

    /**
     * Invoked when a button representing a maze in the custom_mazes folder is clicked
     * Sends the name of the maze to the MazeInteractor for playing
     *
     * @param e the event to be processed
     */
    @Override
    void actionPerformed(ActionEvent e);

    /**
     * Create a new MazeInteractor and classes it depends on, send a custom maze and run it
     *
     * @param file the name of the custom maze to send to MazeInteractor
     */
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