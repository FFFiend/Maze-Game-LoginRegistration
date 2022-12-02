package use_cases.default_game;

import entities.default_game.IDrawOutputBoundary;
import entities.default_game.Player;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.awt.event.KeyEvent;

/**
 * Use case interactor for mazes
 */
public class MazeInteractor implements IGamePanelInputBoundary {
    private final MazeHazards hazards;
    private final MazeItems items;
    private final CollisionHandler cHandler;
    private final Player player;
    private final int playerSpeed = 1;
    private final int playerStamina = 100;

    public MazeInteractor() {
        hazards = new MazeHazards();
        items = new MazeItems();
        this.player = new Player(1, 1);
        cHandler = new CollisionHandler(items, hazards, player);
        player.setStamina(playerStamina);
    }

    /**
     * Load a maze from a file.
     */
    public void load(String filename) {
        new CustomAssetSetter(filename, items, hazards);
    }

    /**
     * Draw all maze components.
     */
    public void draw(IDrawOutputBoundary d) {
        hazards.draw(d);
        items.draw(d);
    }

    /**
     * Moves the player to the direction specified by the user
     * input keycode.
     *
     * @param keycode the keyboard input
     */
    public void movePlayer(int keycode) {
        if (keycode == KeyEvent.VK_W) {
            if (cHandler.upPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(-playerSpeed);
            }
        }
        if (keycode == KeyEvent.VK_S) {
            if (cHandler.downPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerY(playerSpeed);
            }
        }
        if (keycode == KeyEvent.VK_D) {
            if (cHandler.rightPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(playerSpeed);
            }
        }
        if (keycode == KeyEvent.VK_A) {
            if (cHandler.leftPressed(player.getPlayerX(), player.getPlayerY())) {
                player.movePlayerX(-playerSpeed);
            }
        }
        player.reduceStamina(playerSpeed);
    }

    /**
     * Get the player's current x-coordinate.
     *
     * @return the current x-coordinate
     */
    public int getPlayerX() {
        return player.getPlayerX();
    }

    /**
     * Get the player's current y-coordinate.
     *
     * @return the current y-coordinate.
     */
    public int getPlayerY() {
        return player.getPlayerY();
    }

    /**
     * Get the player's current stamina.
     *
     * @return player's current stamina
     **/
    public int getPlayerStamina() {
        return player.getPlayerStamina();
    }

}
