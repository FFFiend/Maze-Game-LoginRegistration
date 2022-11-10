package adapters.default_game;

import use_cases.default_game.IGamePanelPresenterUpdater;

import javax.swing.*;
import java.awt.*;

/**
 * A class responsible for what the GamePanelUI presents
 **/
public class GamePanelPresenter extends JPanel implements IGamePanelPresenterUpdater {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    /**
     * Construct a new GamePanelPresenter with fixed settings
     **/
    public GamePanelPresenter() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
