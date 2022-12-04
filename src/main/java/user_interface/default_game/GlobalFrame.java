package user_interface.default_game;

import user_interface.login_leaderboard.IGlobalFrameOutputBoundary;
import user_interface.login_leaderboard.Panel;
import user_interface.login_leaderboard.PanelManager;

import javax.swing.*;


public class GlobalFrame implements IGlobalFrameOutputBoundary {
    public JFrame window = new JFrame();
    private PanelManager panelManager = new PanelManager();
    private Panel currPanel;
    /**
     * A frame that controls the whole project (not implemented yet).
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

    public void getCurrPanel(Panel panel) {
        currPanel = panel;
    }
    public void changePanelTo(String nextPanel){
        currPanel.delete();

        window.add(panelManager.getNextPanel(nextPanel));

        window.revalidate();
        window.repaint();
        window.pack();

        window.setResizable(true);

        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);
    }
}