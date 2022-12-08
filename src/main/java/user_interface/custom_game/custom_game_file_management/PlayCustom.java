package user_interface.custom_game.custom_game_file_management;

import adapters.custom_game.IPlayCustom;
import java.awt.event.ActionEvent;

public class PlayCustom implements IPlayCustom {
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
//        String file = "custom_mazes/" + MAZE_NAME;
//        JFrame window = new JFrame();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setResizable(false);
//        window.setTitle(file);
//
//        IGamePanelOutputBoundary presenter = new GamePanelPresenter();
//        MazeInteractor maze = new MazeInteractor(presenter);
//        maze.load(file);
//        maze.startGameThread();
//        GamePanelController controller = new GamePanelController(maze);
//
//        window.add((Component) presenter);
//        window.pack();
//        window.setLocationRelativeTo(null);
//        window.setVisible(true);
//
//        window.addKeyListener(controller);
//        window.setFocusable(true);
    }
}
