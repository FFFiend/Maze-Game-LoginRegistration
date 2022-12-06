import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutput;
import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
import user_interface.default_game.GlobalFrame;
import user_interface.login_leaderboard.*;

import javax.swing.*;
import java.awt.*;

/**
 * Run the game
 **/
public class Main {
    /**
     * Run this method to run the game panel
     *
     * @param args for when we need some input
     */
    public static void main(String[] args) {
        setupGame();
    }

    /**
     * Build the Game Panel. Comment out the appropriate use case method
     * to observe functionality.
     **/
    private static void setupGame() {
        IGlobalFrameOutputBoundary ob = new GlobalFrame();
        WelcomeGlobalFrame welcome  = new WelcomeGlobalFrame(ob);
        ob.setPanel(welcome);
        //setupCustomMazeMenu();
        tempDefaultGameRunner();
    }

    /**
     * Temporary access to the custom maze main menu. Please uncomment from setupGame method
     * to use.
     **/
    private static void setupCustomMazeMenu() {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel();
    }

    /**
     * Temporary access to the default game. Please uncomment from setupGame method to use.
     **/
    private static void tempDefaultGameRunner() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("AstroMaze");

        GamePanelPresenter presenter = new GamePanelPresenter();
        IFileOutput output = new FileWriter();

        MazeInteractor maze = new MazeInteractor(presenter, output);
        GamePanelController controller = new GamePanelController(maze);

        window.add((Component) presenter);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addKeyListener(controller);
        window.setFocusable(true);
    }
}