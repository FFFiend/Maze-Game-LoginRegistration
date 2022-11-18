package user_interface.custom_game.custom_game_panels;

import javax.swing.*;
import java.awt.*;

class CustomGameEditorPanel implements ICustomGamePanel {
    //extends Panels

    /**
     * Displays the custom maze editor: a grid to build the maze, a bar to input stamina and a few buttons for saving,
     * and returning to previous menus
     */
    protected CustomGameEditorPanel (){
        //will use Panels' methods to draw and CustomGamePanelInterface for the features specific to custom game
        //panels once those are implemented
        //for now, this is temporarily based on Rene's GamePanel code for visualization of the editor
        final int SPRITE_TILE_SIZE = 16;
        final int SCALE = 3; // may be changed to an unfixed variable later
        final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
        final int MAX_PANEL_COL= 16;
        final int MAX_PANEL_ROW = 12;
        final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
        final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;

        EditorGrid editorGrid = new EditorGrid(MAX_PANEL_ROW, MAX_PANEL_COL, TILE_SIZE);

        JFrame editorFrame = new JFrame("Maze Editor");
        editorFrame.setLayout(new BorderLayout());
        editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorFrame.setResizable(false);
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        editorFrame.setBackground(Color.black);

        editorFrame.add(editorGrid, BorderLayout.CENTER);

//        JTextField staminaField = new JTextField("stamina");
//        editorFrame.add(staminaField, BorderLayout.LINE_END);

        JButton submissionButton = new JButton("submit");
        editorFrame.add(submissionButton, BorderLayout.PAGE_END);

        editorFrame.pack();
        editorFrame.setLocationByPlatform(true);
        editorFrame.setVisible(true);
    }
}