package frameworks_and_drivers.custom_game.custom_game_file_management;

import adapters.custom_game.TempMazeAdapter;
import use_cases.custom_game.custom_game_file_management.ICustomGameFileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles all reading and writing to the files used by the customization feature
 */
public class CustomGameFileManager implements ICustomGameFileManager{

    /**
     * Store a custom maze in the custom_mazes folder
     * (assumes the maze has already been verified to be both writable and solvable)
     */
    public void storeNewCustomMaze() {
        try {
            String mazeName = "custom_mazes/" + TempMazeAdapter.getMazeTitle();
            File mazeFile = new File(mazeName);
            FileWriter mazeWriter = new FileWriter(mazeFile);

            for (int x = 0; x < TempMazeAdapter.getRowTotal(); x++) {
                for (int y = 0; y < TempMazeAdapter.getColumnTotal(); y++) {
                    mazeWriter.write(TempMazeAdapter.getTileNum(x, y) + " ");
                }
                mazeWriter.write(System.getProperty("line.separator"));
            }
            mazeWriter.close();

        } catch (IOException e) {
            System.out.println("unable to store this custom maze");
            e.printStackTrace();
        }
    }

    /**
     * List all the file names of custom mazes stored locally
     *
     * @return the names in an ArrayList of Strings
     */
    public ArrayList<String> listCustomMazes() {
        File[] mazeFileList = new File("custom_mazes/").listFiles();
        ArrayList<String> mazeList = new ArrayList<>();

        assert mazeFileList != null;
        for (File file : mazeFileList) {
            mazeList.add(file.getName());
        }
        return mazeList;
    }
}