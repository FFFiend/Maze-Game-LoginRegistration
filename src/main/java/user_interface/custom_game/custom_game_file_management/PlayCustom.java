package user_interface.custom_game.custom_game_file_management;

import adapters.custom_game.IPlayCustom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayCustom implements IPlayCustom, ActionListener {
    private final String MAZE_NAME;

    /**
     * Generate a new action listener for buttons listing mazes on CustomGameMainPanel
     *
     * @param mazeName the file name of the maze the button is representing
     */
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
        this.getMazeInteractor(MAZE_NAME);
    }
}