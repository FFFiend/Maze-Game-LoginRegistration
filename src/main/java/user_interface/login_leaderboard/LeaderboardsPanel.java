package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows user to pick between the easy, medium, or hard leaderboard.
 */
public class LeaderboardsPanel extends Panel{

    /**
     * pulls directly from filereader.
     */
    public LeaderboardsPanel(IGlobalFrameOutputBoundary ob) {
        this.build();
        this.outputBoundary = ob;

        // TODO: READ CSV and present current leaderboard in tabular format.




    }
}
