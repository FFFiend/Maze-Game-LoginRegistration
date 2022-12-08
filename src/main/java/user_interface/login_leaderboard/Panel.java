package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A class that takes care of all the design commonalities between each panel.
 */


public class Panel extends JPanel {
    private final Color TEXT_COLOR = new Color(239, 235, 230);
    private final Font TEXT_FONT = new Font("Arial", Font.ITALIC, 24);
    public ArrayList<JLabel> labelSet = new ArrayList<>();
    public IGlobalFrameOutputBoundary outputBoundary;

    /**
     * General Panel formatting.
     */
    public void build() {
        int PANEL_WIDTH = 768;
        int PANEL_HEIGHT = 576;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        this.setBackground(new Color(0, 0, 0));
        this.setLayout(null);
        this.setVisible(true);
    }

    /**
     * General label formatting.
     */
    public void labelFormat(ArrayList<JLabel> label){
        for (JLabel jLabel : label) {
            jLabel.setForeground(this.TEXT_COLOR);
            jLabel.setFont(this.TEXT_FONT);
        }
    }

    /**
     * Panel delete method that hides the current panel from the view.
     */
    public void delete(){
        this.setVisible(false);
    }
}
