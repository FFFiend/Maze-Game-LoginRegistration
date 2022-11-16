package user_interface.custom_game.custom_game_screens;

import javax.swing.*;
import java.awt.*;

class CustomGameEditorScreen implements ICustomGameScreen {
    //extends Screens

    /**
     * Displays the custom maze editor: a grid to build the maze, a bar to input stamina and a few buttons for saving,
     * and returning to previous menus
     */
    protected CustomGameEditorScreen(){
        //will use Screens' methods to draw and CustomGameScreenInterface for the features specific to custom game
        //screens once those are implemented
        //for now, this is  temporarily based on Rene's GamePanel code for visualization of the editor
        int rowNum = 12;
        int colNum = 12;
        final int SPRITE_TILE_SIZE = 16;
        final int SCALE = 3; // may be changed to an unfixed variable later
        final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
        final int MAX_PANEL_COL= 16;
        final int MAX_PANEL_ROW = 12;
        final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
        final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;

        EditorGrid editorGrid = new EditorGrid(rowNum, colNum, TILE_SIZE);
        //EditorSidebar editorSidebar = new EditorSidebar(MAX_PANEL_COL, MAX_PANEL_ROW);

        JFrame editorFrame = new JFrame("Maze Editor");
        editorFrame.setLayout(new FlowLayout());
        editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorFrame.setResizable(false);
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        editorFrame.setBackground(Color.black);

        editorFrame.add(editorGrid);
        //JTextField staminaField = new JTextField("stamina");
        //editorFrame.add(staminaField);
        //editorFrame.add(editorSidebar);

        //editorSidebar.setMinimumSize(new Dimension(MAX_PANEL_COL - MAX_PANEL_ROW, MAX_PANEL_ROW));

        editorFrame.pack();
        editorFrame.setLocationByPlatform(true);
        editorFrame.setVisible(true);

    }


}