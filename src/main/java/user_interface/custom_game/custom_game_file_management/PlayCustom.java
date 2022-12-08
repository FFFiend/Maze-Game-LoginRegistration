package user_interface.custom_game.custom_game_file_management;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.custom_game.custom_game_file_management.IPLayCustom;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayCustom implements IPLayCustom {
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

        GamePanelPresenter presenter = new GamePanelPresenter();
        GamePanelController controller = new GamePanelController(this.getMazeInteractor(presenter, "custom_mazes/" + MAZE_NAME));

        window.add(presenter);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addKeyListener(controller);
        window.setFocusable(true);
    }
}
