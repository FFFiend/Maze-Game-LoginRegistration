package adapters.default_game;

import use_cases.default_game.IGamePanelPresenterUpdater;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanelUI presents 
 **/
public class GamePanelPresenter extends JPanel implements IGamePanelPresenterUpdater {
    final int SPRITE_TILE_SIZE = 16;
    final int SCALE = 3; // may be changed to an unfixed variable later
    final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    final int MAX_PANEL_COL= 16;
    final int MAX_PANEL_ROW = 12;
    final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
    final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;

    /**
     * Construct a new GamePanelPresenter with fixed settings
     **/
    public GamePanelPresenter() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
