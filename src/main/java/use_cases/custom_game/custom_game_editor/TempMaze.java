package use_cases.custom_game.custom_game_editor;

import entities.custom_game.EditorTile;

import javax.swing.*;
import java.awt.*;

/**
 * A place to store a custom maze while it is being edited and methods to convert it into a text file
 */
public class TempMaze {
    private static EditorTile[][] tileGrid;
    private static String mazeTitle;
    private static String mazeCreator;

    // Note that for this class, rows and columns on the grid start at 1 and any use of an x or y starts at 0
    private static int rows;
    private static int cols;

    /**
     * Redefine tileGrid with dimensions
     *
     * @param rows the number of rows there will be in this new maze
     * @param cols the number of columns there will be in this new maze
     */
    public static void setGridSize(int rows, int cols) {
        TempMaze.tileGrid = new EditorTile[rows][cols];
        TempMaze.rows = rows;
        TempMaze.cols = cols;
    }

    /**
     * Add a new Tile object to tileGrid, helper method for build
     *
     * @param x the x position of the Tile to be added
     * @param y the y position of the Tile to be added
     * @param tile the Tile object to be added to tileGrid
     */
    private static void addTile(int x, int y, EditorTile tile) {
        TempMaze.tileGrid[x][y] = tile;
    }

    /**
     * Fill out tileGrid with EditorTiles, give each a mouse listener, and add allow the EditorPanel to display them
     *
     * @param grid the panel EditorPanel will display with representations of each EditorTile
     * @param rows the number of rows in the grid (starts at 1)
     * @param cols the number of columns in the grid (starts at 1)
     * @param tileSize the space the tile will be allowed to take on the UI
     */
    public static void build(JPanel grid, int rows, int cols, int tileSize){
        TempMaze.setGridSize(rows, cols);

        grid.setLayout(new GridLayout(rows, cols, 0, 0));
        Dimension tileDimensions = new Dimension(tileSize, tileSize);

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                EditorTile tile = new EditorTile();
                if (x == 1 && y == 1) { //the start location is position (1, 1) and it cannot be changed
                    tile.setStartTile();
                } else {
                    tile.addMouseListener(new EditorOnClick(tile));
                }
                TempMaze.addTile(x, y, tile);
                tile.setPreferredSize(tileDimensions);
                grid.add(tile);
            }
        }
    }

    /**
     * Sets the title of this TempMaze to be stored later in the custom maze text files
     *
     * @param title the unique title of this TempMaze
     */
    public static void setMazeTitle(String title) {
        TempMaze.mazeTitle = title;
    }

    /**
     * Gets the title of this TempMaze for storage in the custom maze text files
     */
    public static String getMazeTitle() {
        return TempMaze.mazeTitle;
    }

    /**
     * Sets the title of this TempMaze to be stored later in the custom maze text files
     *
     * @param creator the username of the user creating this TempMaze
     */
    public static void setMazeCreator(String creator) {
        TempMaze.mazeCreator = creator;
    }

    /**
     * Gets the username of the creator of this TempMaze for storage in the custom maze text files
     */
    public static String getMazeCreator() {
        return TempMaze.mazeCreator;
    }

    /**
     * Gets the TempMaze object
     */
    public static EditorTile[][] getMaze() {
        return TempMaze.tileGrid;
    }

    /**
     * Get the number representing the Tile at (x, y) for storage in text files
     *
     * @param x the x position of the Tile to be retrieved
     * @param y the y position of the Tile to be retrieved
     * @return the number representing the EditorTile at position (x, y)
     */
    public static int getTileNum(int x, int y) {
        if (x < rows && y < cols) {
            return tileGrid[x][y].getNumCode();
        } else {
            throw new RuntimeException("Requested tile does not exist");
        }
    }

    /**
     * @return the number of rows in this TempMaze
     */
    public static int getRowTotal() {
        return tileGrid.length;
    }

    /**
     * @return the number of columns in this TempMaze
     */
    public static int getColumnTotal() {
        return tileGrid[0].length;
    }
}