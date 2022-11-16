package user_interface.custom_game.custom_game_screens;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import adapters.custom_game.custom_game_file_adapters.TempMaze;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

class EditorGrid extends JPanel{

    /**
     * A grid for building a custom maze and one of the components to display on CustomGameEditorScreen
     * @param rows the number of rows there will be in this new maze
     * @param cols the number of columns there will be in this new maze
     * @param tileSize the height and width of a tile's display
     */
    public EditorGrid (int rows, int cols, int tileSize){
        TempMaze.setGridSize(rows, cols); //to be handled by input boundary later maybe

        setLayout(new GridLayout(rows, cols, 0, 0));
        Dimension tileDimensions = new Dimension(tileSize, tileSize);

        for (int x = 0; x < rows; x++){
            for (int y = 0; y < cols; y++){
                EditorTile tile = new EditorTile(x, y);

                TempMaze.addTile(x, y, tile);

                tile.addMouseListener(new EditorOnClick(tile));
                tile.setPreferredSize(tileDimensions);

                add(tile);
            }
        }
    }
}


