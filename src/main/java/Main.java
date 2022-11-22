import adapters.login_leaderboard.RegisterUserController;
import adapters.login_leaderboard.RegisterUserPresenter;
import use_cases.login_leaderboard.IRegisterUserInputBoundary;
import use_cases.login_leaderboard.IRegisterUserOutputBoundary;
import use_cases.login_leaderboard.RegisterUser;
import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
import user_interface.default_game.GlobalFrame;
import user_interface.default_game.GamePanel;
import user_interface.login_leaderboard.RegisterPanel;
import user_interface.login_leaderboard.WelcomePanel;

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
        //setupCustomMazeMenu();
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGame() {
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setPanel(new WelcomePanel());
        tempDefaultGameRunner();
        setupRegisterUseCase();
    }


    /**
     * Temporary acess to the Register User use case.
     **/
    private static void setupRegisterUseCase(){
        GlobalFrame globalFrame = new GlobalFrame();

        IRegisterUserOutputBoundary output = new RegisterUserPresenter();

        IRegisterUserInputBoundary input = new RegisterUser(output);
        // Register user class initialized.

        RegisterUserController controller = new RegisterUserController(input);
        RegisterPanel register = new RegisterPanel(controller);
        globalFrame.setPanel(register);
    }



    /**
     * Temporary access to the custom maze main menu
     **/
    private static void setupCustomMazeMenu () {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel();
    }

    /**
     * Temporary access to the default game
     **/
    private static void tempDefaultGameRunner(){
        GamePanel gamePanelUI = new GamePanel();
        gamePanelUI.createGamePanel();
    }


}
