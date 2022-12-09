package frameworks_and_drivers.custom_game.custom_game_panels;

import adapters.custom_game.ICustomGamePresenter;
import adapters.custom_game.ICustomInitializerInput;
import adapters.custom_game.ValidatorAdapter;
import frameworks_and_drivers.custom_game.custom_game_file_management.CustomGameFileManager;

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
    private ICustomInitializerInput initializer = null;
    private String NEW_PANEL;

    private final CustomGameFileManager FILE_MANAGER = new CustomGameFileManager();

    private final ValidatorAdapter VALIDATOR_ADAPTOR = new ValidatorAdapter();

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
        this.initializer = initializer;
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
    }

    /**
     * Given PANEL, decide where the user should be taken next
     *
     * @param e represents a click on a button in one of the custom maze panels
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(PANEL, "CustomGameEditorPanel")) {
            if (VALIDATOR_ADAPTOR.verifyEditorInput(FILE_MANAGER, PRESENTER)){
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
            assert initializer != null;
            if (VALIDATOR_ADAPTOR.verifyInitializerInput(FILE_MANAGER, PRESENTER, initializer)) {
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
}