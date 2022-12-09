package custom_game;

import adapters.custom_game.TempMazeAdapter;
import entities.custom_game.EditorTile;
import entities.default_game.MazeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.custom_game.custom_game_editor.TempMaze;

import javax.swing.*;

/**
 * Tests for TempMazeAdapter that are not already covered in other testing classes
 */
public class TempMazeAdapterTest {
    public TempMazeAdapterTest() {
        TempMazeAdapter.prepareTempMaze("testing", 10, 10, 10);
    }

    /**
     * Check that TempMazeAdapter can store maze names properly
     */
    @Test
    void mazeName() {
        Assertions.assertEquals(TempMaze.getMazeTitle(), "testing");
    }

    /**
     * Check that TempMazeAdaptor sends info to TempMaze correctly
     */
    @Test
    void buildTempMaze() {
        TempMazeAdapter.buildTempMaze(new JPanel());
        EditorTile[][] maze = TempMaze.getMaze();
        Assertions.assertEquals(MazeInfo.getAssetCodeEmpty(), maze[0][0].getNumCode());
        Assertions.assertEquals(MazeInfo.getAssetCodeEmpty(), maze[9][9].getNumCode());
    }
}
