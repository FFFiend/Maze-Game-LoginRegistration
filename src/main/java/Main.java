import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import adapters.login_leaderboard.*;
import frameworks_and_drivers.default_game.PanelManager;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.*;
import frameworks_and_drivers.default_game.GlobalFrame;
import frameworks_and_drivers.login_leaderboard.*;

/**
 * Run the game
 */
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
        setupPanels();
    }

    /**
     * Set up the panels by creating the use cases and adapters and store it in
     * PanelManager. Panels are created in PanelManager.
     */
    private static void setupPanels() {
        setupRegisterPanel();

        setupLoginPanel();

        setupGamePanel();
    }

    /**
     * Set up a game panel.
     */
    private static void setupGamePanel() {
        GamePanelPresenter presenter = new GamePanelPresenter();
        IFileOutputBoundary output = new FileWriter();

        MazeInteractor maze = new MazeInteractor(presenter, output);
        GamePanelController controller = new GamePanelController(maze);

        presenter.addKeyListener(controller);
        presenter.setFocusable(true);

        PanelManager.assign("GamePanelPresenter", presenter);
    }

    /**
     * Set up a login panel.
     */
    private static void setupLoginPanel() {
        ILoginUserOutputBoundary loginOb = new LoginUserPresenter();
        LoginUser loginUseCase = new LoginUser(loginOb);

        loginUseCase.setUsers(FileReader.create().PREV.getUsers());

        LoginUserController loginController = new LoginUserController(loginUseCase);
        PanelManager.assign("LoginUserController", loginController);
    }

    /**
     * Set up a register panel.
     */
    private static void setupRegisterPanel() {
        IRegisterUserOutputBoundary registerOb = new RegisterUserPresenter();
        IFileOutputBoundary output = new FileWriter();

        RegisterUser registerUseCase = new RegisterUser(registerOb, output);
        registerUseCase.setUsers(FileReader.create().PREV.getUsers());

        RegisterUserController registerController = new RegisterUserController(registerUseCase);
        PanelManager.assign("RegisterUserController", registerController);
    }
}