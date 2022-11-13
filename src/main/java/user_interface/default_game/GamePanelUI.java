package user_interface.default_game;

import adapters.default_game.GamePanelPresenter;

import javax.swing.*;

/**
 * Responsible for what the user sees
 **/
public class GamePanelUI {
    /**
     * Create a new GamePanelUI
     **/
    public void createGamePanelUI() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("AstroMaze");

        GamePanelPresenter presenter = new GamePanelPresenter();
        window.add(presenter);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
