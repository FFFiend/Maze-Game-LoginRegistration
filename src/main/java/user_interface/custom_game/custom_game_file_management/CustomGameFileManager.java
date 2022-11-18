package user_interface.custom_game.custom_game_file_management;

import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_inner_file_management.ICustomGameFileManager;
import java.io.FileWriter;
import java.io.IOException;

public class CustomGameFileManager implements ICustomGameFileManager{

    /**
     * Store a custom maze in customMazes.txt
     * (assumes the maze has already been verified to be both writable and solvable)
     */
    @Override
    public void storeNewCustomMaze(){
        try {
            FileWriter mazeWriter = new FileWriter("customMazes/customMazes.txt", true);

            mazeWriter.write("*Maze Name*");
            //mazeWriter.write(TempMaze.getMazeTitle());
            //the line above will be implemented once the initializer is done
            mazeWriter.write(System.getProperty("line.separator"));  //starts a new line

            mazeWriter.write("*Maze Creator*");
            //mazeWriter.write(TempMaze.getMazeCreator());
            //the line above will be implemented once the initializer is done
            mazeWriter.write(System.getProperty("line.separator"));

            for (int x = 0; x < TempMaze.getRowTotal(); x++) {
                for (int y = 0; y < TempMaze.getColumnTotal(); y++) {
                    mazeWriter.write(TempMaze.getTileNum(x, y) + " ");
                }
                mazeWriter.write(System.getProperty("line.separator"));
            }
            mazeWriter.write(System.getProperty("line.separator"));
            mazeWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
