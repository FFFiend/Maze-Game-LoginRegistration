import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import adapters.login_leaderboard.LoginUserController;
import adapters.login_leaderboard.LoginUserPresenter;
import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.default_game.IGamePanelOutputBoundary;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.*;
import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
import user_interface.default_game.GlobalFrame;
import user_interface.login_leaderboard.FileReader;
import user_interface.login_leaderboard.LoginPanel;
import user_interface.login_leaderboard.RegisterPanel;
import user_interface.login_leaderboard.WelcomePanel;

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
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setPanel(new WelcomePanel());
        //setupCustomMazeMenu();
        tempDefaultGameRunner();
        //setupRegisterUseCase();
        //setupLoginUseCase();
    }

    /**
     * Temporary acess to the Register User use case. Please uncomment from setupGame
     * method to use.
     **/
    private static void setupRegisterUseCase(){
        GlobalFrame globalFrame = new GlobalFrame();

        IRegisterUserOutputBoundary output = new RegisterUserPresenter();
        RegisterUser registerUseCase = new RegisterUser(output);
        registerUseCase.setUsers(FileReader.create().PREV.getUsers());

        RegisterUserController controller = new RegisterUserController(registerUseCase);
        RegisterPanel register = new RegisterPanel(controller);
        globalFrame.setPanel(register);
    }

    /**
     * Access to the Login User use case. Please uncomment from setupGame method
     * to use.
     */
    private static void setupLoginUseCase(){
        GlobalFrame globalFrame = new GlobalFrame();

        ILoginUserOutputBoundary output = new LoginUserPresenter();
        LoginUser loginUseCase = new LoginUser(output);
        loginUseCase.setUsers(FileReader.create().PREV.getUsers());

        LoginUserController controller = new LoginUserController(loginUseCase);
        LoginPanel login =  new LoginPanel(controller);
        globalFrame.setPanel(login);
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

        MazeInteractor maze = new MazeInteractor();
        maze.load("mazes/maze02.txt");

        IGamePanelOutputBoundary presenter = new GamePanelPresenter(maze);
        GamePanelController controller = new GamePanelController(maze);


        window.add((Component) presenter);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        window.addKeyListener(controller);
        window.setFocusable(true);
    }
}