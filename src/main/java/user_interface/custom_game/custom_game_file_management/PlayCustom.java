package user_interface.custom_game.custom_game_file_management;

import adapters.custom_game.IPLayCustom;
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
        this.getMazeInteractor(MAZE_NAME);
    }
}
