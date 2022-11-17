package user_interface.default_game;

import user_interface.login_leaderboard.LoginPanel;
import user_interface.login_leaderboard.RegisterPanel;
import user_interface.login_leaderboard.WelcomePanel;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame {
    public JFrame window = new JFrame();
    public final int FRAME_WIDTH = 768;
    public final int FRAME_HEIGHT = 576;

    /**
     * A frame that controls the whole project (not implemented yet).
     **/
    public GlobalFrame() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("AstroMaze");
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        window.setResizable(false);
        window.setVisible(true);

    }

    /**
     * Sets the initial panel of the frame to the welcome screen.
     */
    public void setWelcomePanel() {
        WelcomePanel welcomePanel = new WelcomePanel();
        window.add(welcomePanel);

        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        if (welcomePanel.state == 1) {
            RegisterPanel registerWindow = new RegisterPanel();
            changePanel(registerWindow);
        } else if (welcomePanel.state == 0) {
            LoginPanel loginWindow = new LoginPanel();
            changePanel(loginWindow);
        }


        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);

    }

    /**
     * Remove the current panel on the frame and switch to another panel.
     *
     * @param nextPanel the next panel that will be displayed
     */
    public void changePanel(JPanel nextPanel) {
        window.removeAll();
        window.add(nextPanel);
        window.revalidate();
        window.repaint();
        window.setVisible(true);

        // does not remember state of frame before
    }
}
