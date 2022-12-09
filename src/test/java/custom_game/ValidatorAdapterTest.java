package custom_game;

import adapters.custom_game.ValidatorAdapter;
import entities.custom_game.EditorTile;
import frameworks_and_drivers.custom_game.custom_game_file_management.CustomGameFileManager;
import frameworks_and_drivers.custom_game.custom_game_panels.CustomGamePresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.custom_game.custom_game_editor.TempMaze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Basic tests for ValidatorAdapter
 */
public class ValidatorAdapterTest {

    /**
     * Test that a valid maze gets stored
     */
    @Test
    void verifyEditorInputValid(){
        try {
            ValidatorAdapter adapter = new ValidatorAdapter();
            TempMaze.build(new JPanel(), 4, 4, 10);
            TempMaze.setMazeTitle("testingMaze");
            EditorTile[][] maze = TempMaze.getMaze();
            maze[3][3].tileRightClick(1); //key
            maze[3][2].tileRightClick(4); //goal/end
            maze[1][2].tileLeftClick();
            maze[0][3].tileLeftClick();
            adapter.verifyEditorInput(new CustomGameFileManager(), new CustomGamePresenter());
            ArrayList<String> mazeList = new CustomGameFileManager().listCustomMazes();
            Assertions.assertTrue(mazeList.contains("testingMaze"));
        } catch (HeadlessException e) {
        // When GitHub is running this code it can't create a new file as this test requires
        }
    }
}