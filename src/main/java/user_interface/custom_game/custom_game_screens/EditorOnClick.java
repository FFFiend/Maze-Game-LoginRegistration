package user_interface.custom_game.custom_game_screens;
import adapters.custom_game.custom_game_file_adapters.EditorTile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Reacts to clicks on CustomGameEditorScreen
 */
class EditorOnClick extends MouseAdapter {
    private final EditorTile tile;
    private int rightClickCount = 0;

    /**
     * Creates a new mouse listener and links it to the EditorTile it responds to
     * @param tile the EditorTile this mouse listener will be assigned to
     */
    public EditorOnClick (EditorTile tile){
        this.tile = tile;
    }

    /**
     * Reacts to left and right mouse clicks on an EditorTile
     * @param click the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent click){
        if (click.getButton() == MouseEvent.BUTTON1){
            this.tile.tileLeftClick();
        } else if (click.getButton() == MouseEvent.BUTTON3) {
            this.tile.tileRightClick(rightClickCount);
            this.rightClickCount++;
            if (rightClickCount == EditorTile.secondaryMenuItemsLen){
                rightClickCount = 0;
            }
        }
    }

}