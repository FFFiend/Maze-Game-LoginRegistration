package frameworks_and_drivers.default_game;

import frameworks_and_drivers.login_leaderboard.IGlobalFrameOutputBoundary;
import frameworks_and_drivers.login_leaderboard.Panel;
import frameworks_and_drivers.login_leaderboard.PanelManager;

import javax.swing.*;

/**
 * A frame that controls the whole project.
 **/
public class GlobalFrame implements IGlobalFrameOutputBoundary {
    public JFrame window = new JFrame();
    private final PanelManager panelManager = new PanelManager();
    private Panel currPanel;

    /**
     * Set up the frame.
     **/
    public GlobalFrame() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("AstroMaze");
        int FRAME_WIDTH = 768;
        int FRAME_HEIGHT = 576;
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        window.setResizable(false);
        window.setVisible(true);
    }

    /**
     * Sets the initial panel of the frame to the welcome screen.
     */
    public void setPanel(Panel panel) {

        window.add(panel);

        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);
    }

    /**
     * Get the current panel
     *
     * @param panel current panel the frame is displaying
     */
    public void getCurrPanel(Panel panel) {
        currPanel = panel;
    }

    /**
     * Change the panel that the frame is displaying.
     *
     * @param nextPanel panel to switch to
     */
    public void changePanelTo(String nextPanel) {
        currPanel.delete();

        window.add(panelManager.getNextPanel(nextPanel, currPanel));

        window.pack();

        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);
    }
}