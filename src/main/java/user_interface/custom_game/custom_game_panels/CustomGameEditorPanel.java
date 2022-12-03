package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameGeneralInputHandler;
import adapters.custom_game.custom_game_UI_adapters.TempMazeAdapter;
import entities.default_game.Maze;

import javax.swing.*;
import java.awt.*;

/**
 * UI to allow the user to build their own maze
 */
class CustomGameEditorPanel extends Panel implements ICustomGamePanel{
    private final JFrame EDITOR_FRAME = new JFrame("Maze Editor");

    /**
     * Displays the custom maze editor: a grid to build the maze, a bar to input stamina and a few buttons for saving,
     * and returning to previous menus
     */
    protected CustomGameEditorPanel() {
        EDITOR_FRAME.setLayout(new BorderLayout());
        EDITOR_FRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EDITOR_FRAME.setResizable(false);
        EDITOR_FRAME.setLocationRelativeTo(null);
        Maze MAZE = new Maze();
        EDITOR_FRAME.setPreferredSize(new Dimension(MAZE.getNum("FRAME_WIDTH"), MAZE.getNum("FRAME_HEIGHT")));
        EDITOR_FRAME.setBackground(Color.black);

        displayEditor();
        displayButtons();

        EDITOR_FRAME.pack();
        EDITOR_FRAME.setLocationByPlatform(true);
        EDITOR_FRAME.setVisible(true);
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
        returnToCustomMainButton(bottomPanel);
        EDITOR_FRAME.add(bottomPanel, BorderLayout.PAGE_END);
    }
}