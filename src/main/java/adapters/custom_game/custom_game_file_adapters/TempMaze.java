package adapters.custom_game.custom_game_file_adapters;

/**
 * A place to store a custom maze while it is being edited and methods to convert it into a text file
 */
public class TempMaze {
    private static EditorGrid[][] tileGrid;

    public static void setGridSize(int rows, int cols){
        TempMaze.tileGrid = new EditorGrid[rows][cols];
    }

    public static void addTile(int x, int y, EditorGrid tile){
        //TODO check if x and y are within bounds first
        TempMaze.tileGrid[x][y] = tile;
    }

    public static EditorGrid displayGrid(int x, int y){
        return tileGrid[x][y]; //for testing later
    }

}
