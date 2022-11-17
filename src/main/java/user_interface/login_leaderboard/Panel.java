package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public final int PANEL_WIDTH = 768;
    public final int PANEL_HEIGHT = 576;

    public final Color TEXT_COLOR = new Color(255, 140, 0);

    public final Font TEXT_FONT = new Font("Arial", Font.BOLD, 17);

    /**
     * A class that takes care of all commonalities between each panel
     * and implements them with its constructor.
     */
    public void build() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        this.setBackground(new Color(0, 35, 102));

        this.setLayout(null);

        this.setVisible(true);

    }
}
