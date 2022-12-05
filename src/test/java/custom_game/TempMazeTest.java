package custom_game;

import entities.custom_game.EditorTile;
import entities.default_game.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.custom_game.custom_game_editor.TempMaze;
import javax.swing.*;

class TempMazeTest {

    private final Maze MAZE = new Maze();

    /**
     * Check that TempMaze can store and retrieve mazes properly
     */
    @Test
    void setGridSize() {
        TempMaze.setGridSize(10, 10);
        EditorTile[][] maze = TempMaze.getMaze();
        Assertions.assertArrayEquals(new EditorTile[10][10], maze);
    }

    /**
     * Check that getRowTotal works
     * Note that an error here might indicate a problem with build.
     */
    @Test
    void getRowTotal() {
        TempMaze.build(new JPanel(), 10, 10, 10);
        Assertions.assertEquals(10, TempMaze.getRowTotal());
    }

    /**
     * Check that getColumnTotal works
     * Note that an error here might indicate a problem with build.
     */
    @Test
    void getColumnTotal() {
        TempMaze.build(new JPanel(), 10, 10, 10);
        Assertions.assertEquals(10, TempMaze.getColumnTotal());
    }

    /**
     * Test maze titles are stored properly
     */
    @Test
    void MazeTitle() {
        TempMaze.setMazeTitle("a brand new maze!");
        Assertions.assertEquals("a brand new maze!", TempMaze.getMazeTitle());
    }

    /**
     * Test maze creators are stored properly
     */
    @Test
    void MazeCreator() {
        TempMaze.setMazeCreator("Username1");
        Assertions.assertEquals("Username1", TempMaze.getMazeCreator());
    }

    /**
     * Check that the correct numCode is returned for a specific tile
     */
    @Test
    void getTileNumValid() {
        TempMaze.build(new JPanel(), 10, 10, 10);
        Assertions.assertEquals(MAZE.getNum("EMPTY_NUM_CODE"), TempMaze.getTileNum(0, 0));
    }

    /**
     * Check that getTileNum handles tiles out of bounds properly
     */
    @Test
    void getTileNumInvalid() {
        TempMaze.build(new JPanel(), 10, 10, 10);

        try {
            TempMaze.getTileNum(10, 0);
        } catch (Exception e){
            Assertions.assertEquals("Requested tile does not exist", e.getMessage());
        }
    }
}