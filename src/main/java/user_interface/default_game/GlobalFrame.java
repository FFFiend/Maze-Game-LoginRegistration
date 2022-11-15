package user_interface.default_game;

import adapters.default_game.GamePanelPresenter;
import user_interface.login_leaderboard.WelcomeScreen;

import javax.swing.*;

public class GlobalFrame {
    public JFrame window;
    public final int FRAME_WIDTH = 16;
    public final int FRAME_HEIGHT = 12;

    /**
     * A frame that controls the whole project (not implemented yet).
     **/
    public GlobalFrame() {
        this.window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("AstroMaze");
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * Sets the initial panel of the frame to the welcome screen.
     */
    public void setWelcomePanel() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        window.add(welcomeScreen);

        window.setLocationRelativeTo(null);
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
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.revalidate();
        // window.repaint();
        // does not remember state of frame before
    }
}
