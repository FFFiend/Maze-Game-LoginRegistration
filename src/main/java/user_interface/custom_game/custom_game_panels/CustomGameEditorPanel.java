package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.CustomGameGeneralInputHandler;
import adapters.custom_game.TempMazeAdapter;
import entities.default_game.MazeInfo;

import javax.swing.*;
import java.awt.*;

/**
 * UI to allow the user to build their own maze
 */
class CustomGameEditorPanel extends Panel implements ICustomGamePanel{
    private static final JFrame EDITOR_FRAME = new JFrame("Maze Editor");

    /**
     * Displays the custom maze editor: a grid to build the maze, a bar to input stamina and a few buttons for saving,
     * and returning to previous menus
     */
    protected CustomGameEditorPanel() {
        EDITOR_FRAME.setLayout(new BorderLayout());
        EDITOR_FRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EDITOR_FRAME.setResizable(false);
        EDITOR_FRAME.setLocationRelativeTo(null);
        EDITOR_FRAME.setPreferredSize(new Dimension(MazeInfo.getPanelWidth(), MazeInfo.getPanelHeight()));
        EDITOR_FRAME.setBackground(Color.black);

        displayEditor();
        displayButtons();

        EDITOR_FRAME.pack();
        EDITOR_FRAME.setVisible(true);
        EDITOR_FRAME.setFocusable(true);
    }

    /**
     * Add the editor to the panel
     */
    private void displayEditor() {
        JPanel panel = new JPanel();
        TempMazeAdapter.buildTempMaze(panel);
        EDITOR_FRAME.add(panel, BorderLayout.CENTER);
    }

    /**
     * Add the submission and back buttons to the panel
     */
    private void displayButtons() {
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton submissionButton = new JButton("submit");
        submissionButton.addActionListener(new CustomGameGeneralInputHandler("CustomGameEditorPanel", new CustomGamePresenter()));

        bottomPanel.add(submissionButton);
        ICustomGamePanel.returnToCustomMainButtonStatic(bottomPanel);
        EDITOR_FRAME.add(bottomPanel, BorderLayout.PAGE_END);
    }

    /**
     * Bring the editor in front of other windows
     */
    protected static void toFront () {
        EDITOR_FRAME.requestFocus();
    }
}