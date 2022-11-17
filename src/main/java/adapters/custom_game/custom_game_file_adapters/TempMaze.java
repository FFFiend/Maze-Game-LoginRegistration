package adapters.custom_game.custom_game_file_adapters;

/**
 * A place to store a custom maze while it is being edited and methods to convert it into a text file
 */
public class TempMaze {
    private static EditorTile[][] tileGrid;

    /**
     * Redefine tileGrid with dimensions
     * @param rows the number of rows there will be in this new maze
     * @param cols the number of columns there will be in this new maze
     */
    public static void setGridSize(int rows, int cols){
        TempMaze.tileGrid = new EditorTile[rows][cols];
    }

    /**
     * Add a new Tile object to tile Grid
     * @param x the x position of the Tile to be added
     * @param y the y position of the Tile to be added
     * @param tile the Tile object to be added to tileGrid
     */
    public static void addTile(int x, int y, EditorTile tile){
        //TODO check if x and y are within bounds first
        TempMaze.tileGrid[x][y] = tile;
    }

    /**
     * return the EditorTile at position (x, y)
     * @param x the x position of the Tile to be retrieved
     * @param y the y position of the Tile to be retrieved
     * */
    public static EditorTile displayGrid(int x, int y){
        return tileGrid[x][y]; //for testing later
    }

}
