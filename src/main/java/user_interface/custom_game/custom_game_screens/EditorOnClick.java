package user_interface.custom_game.custom_game_screens;
import adapters.custom_game.custom_game_file_adapters.EditorGrid;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Reacts to clicks on CustomGameEditorScreen
 */
class EditorOnClick extends MouseAdapter {
    private final EditorGrid tile;
    private int rightClickCount = 0;

    public EditorOnClick (EditorGrid tile){
        this.tile = tile;
    }

    @Override
    public void mousePressed(MouseEvent click){
        if (click.getButton() == MouseEvent.BUTTON1){
            this.tile.tileLeftClick();
        } else if (click.getButton() == MouseEvent.BUTTON3) {
            this.tile.tileRightClick(rightClickCount);
            this.rightClickCount++;
            if (rightClickCount == EditorGrid.secondaryMenuItemsLen){
                rightClickCount = 0;
            }
        }
    }

}