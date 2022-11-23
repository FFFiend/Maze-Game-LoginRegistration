package user_interface.default_game;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import javax.swing.*;

/**
 * Responsible for what the user sees
 **/
public class GamePanel {
    /**
     * Create a new GamePanelUI
     **/
    public void createGamePanel() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("AstroMaze");

        MazeItems items = new MazeItems();
        MazeHazards hazards = new MazeHazards();
        GamePanelPresenter presenter = new GamePanelPresenter(hazards, items);
        window.add(presenter);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        presenter.startGameThread();

        GamePanelController controller = new GamePanelController(hazards, items);
        window.addKeyListener(controller);
        window.setFocusable(true);
    }

}
