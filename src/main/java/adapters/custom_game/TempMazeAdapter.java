package adapters.custom_game;

import use_cases.custom_game.custom_game_editor.TempMaze;

import javax.swing.*;

public class TempMazeAdapter {

    /**
     * rows, cols and tile size of the new editor grid to be displayed.
     * Does not retrieve this information from constants in case customizing grid sizes is a feature added in the future
     */
    private static int rows;
    private static int cols;
    private static int tileSize;

    /**
     * Sends information from the initializer to TempMaze
     */
    public static void prepareTempMaze(String mazeName, int rows, int cols, int tileSize) {
        TempMazeAdapter.rows = rows;
        TempMazeAdapter.cols = cols;
        TempMazeAdapter.tileSize = tileSize;

        TempMaze.setMazeTitle(mazeName);
    }

    /**
     * Build an empty TempMaze out of EditorTiles and make it accessible to the UI
     * @param grid the visible grid on the editor
     */
    public static void buildTempMaze(JPanel grid){
        TempMaze.build(grid, rows, cols, tileSize);
    }

    /**
     * Gets the title of the TempMaze for storage in the custom maze text files
     */
    public static String getMazeTitle() {
        return TempMaze.getMazeTitle();
    }

    /**
     * Get the number representing the Tile at (x, y) for storage in text files
     *
     * @param x the x position of the Tile to be retrieved
     * @param y the y position of the Tile to be retrieved
     * @return the number representing the EditorTile at position (x, y)
     */
    public static int getTileNum(int x, int y) {
        return TempMaze.getTileNum(x, y);
    }

    /**
     * @return the number of rows in the TempMaze
     */
    public static int getRowTotal() {
        return TempMaze.getRowTotal();
    }

    /**
     * @return the number of columns in the TempMaze
     */
    public static int getColumnTotal() {
        return TempMaze.getColumnTotal();
    }
}