package user_interface.login_leaderboard;

import java.awt.*;

/**
 * Allows the user to login, register, or view leaderboard.
 */
public class WelcomeScreen extends Screens {
    public final int PANEL_WIDTH = 16;
    public final int PANEL_HEIGHT = 12;

    /**
     * Construct a new WelcomeScreen panel with fixed settings
     **/
    public WelcomeScreen() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
