package custom_game;

import entities.custom_game.EditorTile;

import entities.default_game.MazeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for EditorTile
 */
class EditorTileTest {

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
        Assertions.assertEquals(MazeInfo.getAssetCodeEmpty(), tile.getNumCode());
    }

    /**
     * Check that a tile can be properly converted to a start tile
     */
    @Test
    void setStartTile() {
        EditorTile tile = new EditorTile();
        tile.setStartTile();
        Assertions.assertEquals(9, tile.getNumCode());
    }

    /**
     * Check that a start tile is not modified when clicked
     */
    @Test
    void StartTileRemainsConstant() {
        EditorTile tile = new EditorTile();
        tile.setStartTile();
        tile.tileRightClick(1);
        tile.tileLeftClick();
        Assertions.assertEquals(9, tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to an oxygen tank
     */
    @Test
    void changeStateOxygen() {
        EditorTile tile = new EditorTile();
        tile.changeState("oxygen");
        Assertions.assertEquals(MazeInfo.getAssetCodeOxygen(), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a stationaryEnemy
     */
    @Test
    void changeStateStationaryEnemy() {
        EditorTile tile = new EditorTile();
        tile.changeState("stationaryEnemy");
        Assertions.assertEquals(MazeInfo.getAssetCodeStationaryEnemy(), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a chasingEnemy
     */
    @Test
    void changeStateChasingEnemy() {
        EditorTile tile = new EditorTile();
        tile.changeState("chasingEnemy");
        Assertions.assertEquals(MazeInfo.getAssetCodeChasingEnemy(), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a key
     */
    @Test
    void changeStateKey() {
        EditorTile tile = new EditorTile();
        tile.changeState("key");
        Assertions.assertEquals(MazeInfo.getAssetCodeKey(), tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to a start location
     */
    @Test
    void changeStateStart() {
        EditorTile tile = new EditorTile();
        tile.changeState("start");
//        Assertions.assertEquals(MazeInfo.getAssetCodeStart(), tile.getNumCode());
        Assertions.assertEquals(9, tile.getNumCode());
    }

    /**
     * Check that changeState converts a tile to an end location
     */
    @Test
    void changeStateEnd() {
        EditorTile tile = new EditorTile();
        tile.changeState("end");
        Assertions.assertEquals(MazeInfo.getAssetCodeGoal(), tile.getNumCode());
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
            Assertions.assertEquals(MazeInfo.getAssetCodeEmpty(), tile.getNumCode());
        }
    }

    /**
     * test tileLeftClick converts an empty tile to an obstacle
     */
    @Test
    void tileLeftClickEmpty() {
        EditorTile tile = new EditorTile();
        tile.tileLeftClick();
        Assertions.assertEquals(MazeInfo.getAssetCodeObstacle(), tile.getNumCode());
    }

    /**
     * test tileLeftClick converts other tile types to an empty tile
     */
    @Test
    void tileLeftClickOther() {
        EditorTile tile = new EditorTile();
        tile.changeState("stationaryEnemy");
        tile.tileLeftClick();
        Assertions.assertEquals(MazeInfo.getAssetCodeEmpty(), tile.getNumCode());
    }

    /**
     * Check that tileRightClick converts tiles to the items in secondaryMenuItems
     */
    @Test
    void tileRightClick() {
        EditorTile tile = new EditorTile();
        tile.tileRightClick(0);
        Assertions.assertEquals(MazeInfo.getAssetCodeOxygen(), tile.getNumCode());
    }
}