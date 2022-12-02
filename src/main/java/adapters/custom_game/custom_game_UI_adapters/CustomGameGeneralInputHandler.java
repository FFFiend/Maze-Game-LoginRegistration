package adapters.custom_game.custom_game_UI_adapters;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_file_management.CustomGameValidator;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Handles clicks to all buttons that should take the user to a new panel to and from the custom maze section
 */
public class CustomGameGeneralInputHandler implements ActionListener {
    private final String PANEL;
    private final ICustomGamePresenter presenter;
    private ICustomInitializerInput initializer;
    private String NEW_PANEL;

    /**
     * Listens for clicks to buttons on the custom maze panels, calls the verifier if necessary and calls the
     * appropriate panels in response.
     *
     * @param panel the current panel of the submission button (CustomGameInitializerPanel or CustomGameEditorPanel)
     * @param presenter an instance of the presenter interface to display a new panel after verification
     */
    public CustomGameGeneralInputHandler (String panel, ICustomGamePresenter presenter) {
        this.PANEL = panel;
        this.presenter = presenter;
    }

    /**
     * Listens for clicks to buttons on the initializer panel, calls the verifier if necessary and calls the
     * appropriate panels in response
     *
     * @param panel the current panel of the submission button (CustomGameInitializerPanel or CustomGameEditorPanel)
     * @param presenter an instance of the presenter interface to display a new panel after verification
     * @param initializer an instance of the initializer interface to allow retrieving of information on its text fields
     */
    public CustomGameGeneralInputHandler (String panel, ICustomGamePresenter presenter, ICustomInitializerInput initializer) {
        this.PANEL = panel;
        this.presenter = presenter;
        this.initializer = initializer;
    }

    /**
     * Listens for clicks to return button on popups, requires its own constructor because popups can be called on multiple
     * panels and can take the user to different places based on where they were called
     *
     * @param panel the current panel of the submission button (CustomGameInitializerPanel or CustomGameEditorPanel)
     * @param presenter an instance of the presenter interface to display a new panel after verification
     * @param newPanel the panel to go to
     */
    public CustomGameGeneralInputHandler (String panel, ICustomGamePresenter presenter, String newPanel) {
        this.PANEL = panel;
        this.presenter = presenter;
        this.NEW_PANEL = newPanel;
    }

    /**
     * Given PANEL, decide where the user should be taken next
     *
     * @param e represents a click on a button in one of the custom maze panels
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(PANEL, "CustomGameEditorPanel")) {
            verifyEditorInput(TempMaze.getMaze());
        }
        else if (Objects.equals(PANEL, "CustomGameMainPanel")) {
            presenter.callCustomGamePanel("CustomGameInitializerPanel");
        }
        else if (Objects.equals(PANEL, "toCustomMain")) {
            presenter.callCustomGamePanel("CustomGameMainPanel");
        }
        else if (Objects.equals(PANEL, "CustomGamePopup")) {
            presenter.callCustomGamePanel(NEW_PANEL);
        }
        else if (Objects.equals(PANEL, "CustomGameInitializerPanel")) {
            verifyInitializerInput();
        }
        else {
            //TODO raise an error
        }
    }

    /**
     * Calls and sends a maze to the verifier. If it is valid, it calls the presenter to return the User to the custom
     * game main menu. If not, it shows the user a panel warning that their input was invalid.
     *
     * @param maze the maze just created in the editor
     */
    public void verifyEditorInput(EditorTile[][] maze) {
        CustomGameValidator validator = new CustomGameValidator();

        if (validator.verifyMaze(maze, new CustomGameFileManager())) {
            presenter.callCustomGamePanel("CustomGameMainPanel");
            presenter.callCustomPopup("Maze stored successfully!");
        }
        else {
            presenter.callCustomPopup("This maze is not valid", "CustomGameInitializerPanel" );
        }
    }

    /**
     * Calls and sends maze initializer values to the verifier. If it is valid, it calls the presenter to take the
     * User to the editor. If not, it shows the user a panel warning that their input was invalid.
     */
    public void verifyInitializerInput() {
        String mazeName = initializer.getMazeName();
        CustomGameValidator validator = new CustomGameValidator();

        if (!validator.verifyName(mazeName, new CustomGameFileManager())) {
            presenter.callCustomPopup("That name is already taken!", "CustomGameInitializerPanel" );
        }
        else { //if more options are included in the initializer, more checks will be added
            presenter.callCustomGamePanel("CustomGameEditorPanel");
            prepareTempMaze(mazeName);
        }
    }

    /**
     * Sends information from the initializer to TempMaze
     */
    public void prepareTempMaze(String mazeName) {
        TempMaze.setMazeTitle(mazeName);
        //TempMaze.setMazeCreator();
    }
}
