package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel parent class that is responsible for designing and formatting
 * the panels.
 */
public class Panel extends JPanel {
    private final Color TEXT_COLOR = new Color(255, 140, 0);
    private final Font TEXT_FONT = new Font("Arial", Font.BOLD, 17);
    public ArrayList<JLabel> labelSet = new ArrayList<>();

    public IGlobalFrameOutputBoundary outputBoundary;
    /**
     * A class that takes care of all commonalities between each panel
     * and implements them with its constructor.
     */
    public void build() {

        int PANEL_WIDTH = 768;
        int PANEL_HEIGHT = 576;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        this.setBackground(new Color(0, 35, 102));

        this.setLayout(null);

        this.setVisible(true);



    }

    /**
     * Method that formats a label in accordance with the theme
     * of the game.
     * @param label the JLabel to be formatted.
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
