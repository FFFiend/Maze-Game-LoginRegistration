package user_interface.custom_game.custom_game_screens;

import adapters.custom_game.custom_game_file_adapters.tempMaze;
import adapters.default_game.GamePanelPresenter;

import javax.swing.*;

class CustomGameEditorScreen implements ICustomGameScreen {
    //extends Screens
    //public tempMaze =
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

        //create an item and display it
        //this breaks CA, but I will fix it later

        tempMaze tempMaze = new tempMaze();
        tempMaze.addAsset("blackhole", 1, 1);


    }


}