package user_interface.custom_game.custom_game_screens;

import adapters.custom_game.custom_game_file_adapters.TempMaze;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * A grid for building a custom maze and one of the components to display on CustomGameEditorScreen
 */
class EditorGrid extends JPanel{
    //private Tile[][] tileGrid;

    public EditorGrid(int rows, int cols, int tileSize){
        //this.tileGrid = new Tile[rows][cols]; <-- from when the maze was stored as a private attribute of this class
        TempMaze.setGridSize(rows, cols); //to be handled by input boundary later maybe

        setLayout(new GridLayout(rows, cols, 0, 0));
        Dimension tileDimensions = new Dimension(tileSize, tileSize);

        //iterate over every column of each row and create a Tile object for each
        for (int x = 0; x < rows; x++){
            for (int y = 0; y < cols; y++){
                adapters.custom_game.custom_game_file_adapters.EditorGrid tile = new adapters.custom_game.custom_game_file_adapters.EditorGrid(x, y);

                //tileGrid[x][y] = tile; <-- from when the maze was stored as a private attribute of this class
                TempMaze.addTile(x, y, tile);

                tile.addMouseListener(new EditorOnClick(tile));
                tile.setPreferredSize(tileDimensions);

                //add it to the UI
                add(tile);
            }
        }
    }
}


