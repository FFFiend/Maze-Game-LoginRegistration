package adapters.custom_game;

import entities.default_game.MazeInfo;
import use_cases.custom_game.custom_game_file_management.CustomGameValidator;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Handles clicks to all buttons that should take the user to a new panel to and from the custom maze section
 */
public class CustomGameGeneralInputHandler implements ActionListener {
    private final String PANEL;
    private final ICustomGamePresenter PRESENTER;
    private final ICustomInitializerInput INITIALIZER;
    private String NEW_PANEL;

    /**
     * Listens for clicks to buttons on the custom maze panels, calls the verifier if necessary and calls the
     * appropriate panels in response.
     *
     * @param panel the current panel of the button
     * @param presenter an instance of the presenter interface to display a new panel after verification
     */
    public CustomGameGeneralInputHandler(String panel, ICustomGamePresenter presenter) {
        this.PANEL = panel;
        this.PRESENTER = presenter;
        this.INITIALIZER = null;
    }

    /**
     * Listens for clicks to buttons on the initializer panel, calls the verifier if necessary and calls the
     * appropriate panels in response
     *
     * @param panel the current panel of the button
     * @param presenter an instance of the presenter interface to display a new panel after verification
     * @param initializer an instance of the initializer interface to allow retrieving of information on its text fields
     */
    public CustomGameGeneralInputHandler(String panel, ICustomGamePresenter presenter, ICustomInitializerInput initializer) {
        this.PANEL = panel;
        this.PRESENTER = presenter;
        this.INITIALIZER = initializer;
    }

    /**
     * Listens for clicks to return button on popups, requires its own constructor because popups can be called on
     * multiple panels and can take the user to different places based on where they were called
     *
     * @param panel the current panel of the button
     * @param presenter an instance of the presenter interface to display a new panel after verification
     * @param newPanel the panel to go to
     */
    public CustomGameGeneralInputHandler(String panel, ICustomGamePresenter presenter, String newPanel) {
        this.PANEL = panel;
        this.PRESENTER = presenter;
        this.NEW_PANEL = newPanel;
        this.INITIALIZER = null;
    }

    /**
     * Given PANEL, decide where the user should be taken next
     *
     * @param e represents a click on a button in one of the custom maze panels
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(PANEL, "CustomGameEditorPanel")) {
            if (verifyEditorInput(new CustomGameValidator())){
                closePanel(e);
            }
        }
        else if (Objects.equals(PANEL, "CustomGameMainPanel")) {
            PRESENTER.callCustomGamePanel("CustomGameInitializerPanel");
            closePanel(e);
        }
        else if (Objects.equals(PANEL, "toCustomMain")) {
            closePanel(e);
            PRESENTER.callCustomGamePanel("CustomGameMainPanel");
        }
        else if (Objects.equals(PANEL, "CustomGamePopup")) {
            closePanel(e);
            if (Objects.equals(NEW_PANEL, "CustomGameEditorPanel")) {
                PRESENTER.refocusEditor();
            } else if (Objects.equals(NEW_PANEL, "CustomGameInitializerPanel")) {
                PRESENTER.refocusInitializer();
            } else {
                PRESENTER.callCustomGamePanel(NEW_PANEL);
            }
        }
        else if (Objects.equals(PANEL, "CustomGameInitializerPanel")) {
            if (verifyInitializerInput()) {
                closePanel(e);
            }
        }
        else {
            throw new RuntimeException("attempted to switch to an invalid panel");
        }
    }

    /**
     * Close the panel with a button that has just been clicked
     *
     * @param e the button click that called the input handler
     */
    private void closePanel(ActionEvent e){
        JComponent component = (JComponent) e.getSource();
        Window window = SwingUtilities.getWindowAncestor(component);
        window.dispose();
    }

    /**
     * Calls and sends a maze to the verifier. If it is valid, it calls the presenter to return the User to the custom
     * game main menu. If not, it shows the user a panel warning that their input was invalid.
     */
    public boolean verifyEditorInput(CustomGameValidator validator) {
        if (validator.verifyMaze(new CustomGameFileManager())) {
            PRESENTER.callCustomGamePanel("CustomGameMainPanel");
            PRESENTER.callCustomPopup("Maze stored successfully!");
            return true;
        }
        else {
            PRESENTER.callCustomPopup("This maze needs at least one black hole and at least one escape pod to be solvable. ", "CustomGameEditorPanel" );
            return false;
        }
    }

    /**
     * Calls and sends maze initializer values to the verifier. If it is valid, it calls the presenter to take the
     * User to the editor. If not, it shows the user a panel warning that their input was invalid.
     */
    public boolean verifyInitializerInput() {
        assert INITIALIZER != null;
        String mazeName = INITIALIZER.getMazeName();
        CustomGameValidator validator = new CustomGameValidator();

        if (!validator.verifyName(mazeName, new CustomGameFileManager())) {
            PRESENTER.callCustomPopup("That name is already taken!", "CustomGameInitializerPanel" );
            return false;
        }
        else { //if more options are included in the initializer, more checks will be added
            //sends in constants as parameters in case customizing grid sizes is a feature added in the future
            TempMazeAdapter.prepareTempMaze(mazeName, MazeInfo.getMaxMazeRow(), MazeInfo.getMaxMazeCol(), MazeInfo.getTileSize());
            PRESENTER.callCustomGamePanel("CustomGameEditorPanel");
            return true;
        }
    }
}
