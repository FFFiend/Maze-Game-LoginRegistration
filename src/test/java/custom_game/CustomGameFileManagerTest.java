package custom_game;

import entities.custom_game.EditorTile;
import org.junit.jupiter.api.Assertions;
import use_cases.custom_game.custom_game_editor.TempMaze;

import org.junit.jupiter.api.Test;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tests for CustomGameFileManager and the classes it depends on
 */
class CustomGameFileManagerTest {
    private final CustomGameFileManager FILE_MANAGER = new CustomGameFileManager();
    private final String MAZE_NAME = "testingMaze";
    File mazeFile;

    /**
     * Create a TempMaze for testing, add some items and store it
     */
    public CustomGameFileManagerTest() {
        TempMaze.build(new JPanel(), 4, 4, 10);
        TempMaze.setMazeTitle(MAZE_NAME);
        EditorTile[][] maze = TempMaze.getMaze();
        maze[3][3].tileRightClick(4);
        maze[1][2].tileLeftClick();
        maze[0][3].tileLeftClick();
        FILE_MANAGER.storeNewCustomMaze();
        mazeFile = new File("custom_mazes/" + MAZE_NAME);
    }

    /**
     * Check that the correct title was assigned
     */
    @Test
    void checkMazeTitle() {
        Assertions.assertEquals(MAZE_NAME, mazeFile.getName());
    }

    /**
     * Check the ListCustomMazes method
     */
    @Test
    void ListCustomMazes() {
        ArrayList<String> mazeList = FILE_MANAGER.listCustomMazes();
        Assertions.assertTrue(mazeList.contains(MAZE_NAME));
    }

    @Test
    void checkContent() {
        String firstLine = "0 0 0 1 ";
        String secondLine = "0 9 1 0 ";
        String thirdLine = "0 0 0 0 ";
        String fourthLine = "0 0 0 6 ";
        try {
            Scanner fileReader = new Scanner(mazeFile);
            Assertions.assertEquals(firstLine, fileReader.nextLine());
            Assertions.assertEquals(secondLine, fileReader.nextLine());
            Assertions.assertEquals(thirdLine, fileReader.nextLine());
            Assertions.assertEquals(fourthLine, fileReader.nextLine());
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read the testingMaze file");
            e.printStackTrace();
        }
        if (!deleteTestingMaze()) {
            System.out.println("automatic deletion did not work, please delete the testingMaze file");
        }
    }

    /**
     * Delete the maze created for testing, to be called in the last test method
     */
    private boolean deleteTestingMaze() {
        return mazeFile.delete();
    }
}