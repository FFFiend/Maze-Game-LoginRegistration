package user_interface.custom_game.custom_game_screens;

import adapters.custom_game.custom_game_file_adapters.tempMaze;
import adapters.default_game.GamePanelPresenter;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.*;

class CustomGameEditorScreen implements ICustomGameScreen {
    //extends Screens

    protected CustomGameEditorScreen(){
        //will use Screens' methods to draw and CustomGameScreenInterface for the features specific to custom game
        //screens once those are implemented

        //for now, this is Rene's GamePanel code reused temporarily for visualization of the editor
        JFrame editorWindow = new JFrame();
        editorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorWindow.setResizable(false);
        editorWindow.setTitle("Maze Editor");
        GamePanelPresenter editorPresenter = new GamePanelPresenter();
        editorWindow.add(editorPresenter);
        editorWindow.pack();
        editorWindow.setLocationRelativeTo(null);
        editorWindow.setVisible(true);


        //make a grid
        //CustomGameEditorGrid editorGrid = new CustomGameEditorGrid(12, 12);
        editorWindow.setLayout(new GridLayout(2, 2));
        for (int i = -1; i < 144; i++) {
            JButton button = new JButton(Integer.toString(i + 1));
            editorWindow.add(button);
        }


        //create an item and display it


        //tempMaze tempMaze = new tempMaze();



    }


}