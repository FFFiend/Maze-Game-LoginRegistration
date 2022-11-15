package adapters.custom_game.custom_game_file_adapters;
public class TempMaze {
    private static Tile[][] tileGrid;

    public static void setGridSize(int rows, int cols){
        TempMaze.tileGrid = new Tile[rows][cols];
    }

    public static void addTile(int x, int y, Tile tile){
        //TODO check if x and y are within bounds first
        TempMaze.tileGrid[x][y] = tile;
    }

    public static Tile displayGrid(int x, int y){
        return tileGrid[x][y]; //for testing later
    }

}
