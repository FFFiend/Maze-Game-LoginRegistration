package adapters.custom_game;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutput;
import user_interface.login_leaderboard.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayCustom implements ActionListener {
    private final String MAZE_NAME;

    public PlayCustom(String mazeName) {
        MAZE_NAME = mazeName;
    }

    /**
     * Invoked when a button representing a maze in the custom_mazes folder is clicked
     * Sends the name of the maze to the MazeInteractor for playing
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(MAZE_NAME);

        IGamePanelOutputBoundary presenter = new GamePanelPresenter();
        IFileOutput output = new FileWriter();
        MazeInteractor maze = new MazeInteractor(presenter, output);
        maze.load("custom_mazes/" + MAZE_NAME);
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
