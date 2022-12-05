package custom_game;

import entities.custom_game.EditorTile;
import entities.default_game.Maze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for EditorTile
 */
class EditorTileTest {

    private final Maze MAZE = new Maze();

    /**
     * Check that a new tile is assigned the right name
     */
    @Test
    void testToString() {
        EditorTile tile = new EditorTile();
        Assertions.assertEquals("empty", tile.toString());
    }

    /**
     * Check that a new tile is assigned the right number
     */
    @Test
    void getNumCode() {
        EditorTile tile = new EditorTile();
        Assertions.assertEquals(MAZE.getNum("EMPTY_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to photons
     */
    @Test
    void changeStatePhotons() {
        EditorTile tile = new EditorTile();
        tile.changeState("photons");
        Assertions.assertEquals(MAZE.getNum("PHOTONS_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a stationaryEnemy
     */
    @Test
    void changeStateStationaryEnemy() {
        EditorTile tile = new EditorTile();
        tile.changeState("stationaryEnemy");
        Assertions.assertEquals(MAZE.getNum("STATIONARY_ENEMY_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a chasingEnemy
     */
    @Test
    void changeStateChasingEnemy() {
        EditorTile tile = new EditorTile();
        tile.changeState("chasingEnemy");
        Assertions.assertEquals(MAZE.getNum("CHASING_ENEMY_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a key
     */
    @Test
    void changeStateKey() {
        EditorTile tile = new EditorTile();
        tile.changeState("key");
        Assertions.assertEquals(MAZE.getNum("KEY_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a start location
     */
    @Test
    void changeStateStart() {
        EditorTile tile = new EditorTile();
        tile.changeState("start");
//        Assertions.assertEquals(MAZE.getNum("START_NUM_CODE"), tile.getNumCode());
        Assertions.assertEquals(9, tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to an end location
     */
    @Test
    void changeStateEnd() {
        EditorTile tile = new EditorTile();
        tile.changeState("end");
        Assertions.assertEquals(MAZE.getNum("END_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that changeState handles invalid inputs correctly
     */
    @Test
    void changeStateInvalidInput(){
        EditorTile tile = new EditorTile();
        try {
            tile.changeState("stationary");
        } catch (Exception e){
            Assertions.assertEquals("invalid tile type given", e.getMessage());
            Assertions.assertEquals(MAZE.getNum("EMPTY_NUM_CODE"), tile.getNumCode());
        }
    }

    /**
     * test tileLeftClick converts an empty tile to an obstacle
     */
    @Test
    void tileLeftClickEmpty() {
        EditorTile tile = new EditorTile();
        tile.tileLeftClick();
        Assertions.assertEquals(MAZE.getNum("OBSTACLE_NUM_CODE"), tile.getNumCode());
    }

    /**
     * test tileLeftClick converts other tile types to an empty tile
     */
    @Test
    void tileLeftClickOther() {
        EditorTile tile = new EditorTile();
        tile.changeState("stationaryEnemy");
        tile.tileLeftClick();
        Assertions.assertEquals(MAZE.getNum("EMPTY_NUM_CODE"), tile.getNumCode());
    }

    /**
     * Check that tileRightClick converts tiles to the items in secondaryMenuItems
     */
    @Test
    void tileRightClick() {
        EditorTile tile = new EditorTile();
        tile.tileRightClick(0);
        Assertions.assertEquals(MAZE.getNum("PHOTONS_NUM_CODE"), tile.getNumCode());
    }
}