package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows user to play, customize maze, or view leaderboard.
 */
public class HomePanel extends Panel implements ActionListener {

    /***
     * Constructs the home panel.
     */
    public HomePanel(IGlobalFrameOutputBoundary ob) {
        this.outputBoundary = ob;
        this.build();

        JButton playGame = new JButton("Play");
        playGame.setBounds(240,100,50,50);
        playGame.setSize(300,50);
        playGame.setFont(new Font("Arial", Font.BOLD, 23));

        JButton playCustom = new JButton("Custom Game");
        playCustom.setBounds(240,250,50,50);
        playCustom.setSize(300,50);
        playCustom.setFont(new Font("Arial", Font.BOLD, 23));

        JButton viewLeaderboard = new JButton("Leaderboard");
        viewLeaderboard.setBounds(240,400,50,50);
        viewLeaderboard.setSize(300,50);
        viewLeaderboard.setFont(new Font("Arial", Font.BOLD, 23));

        this.add(playGame);
        this.add(playCustom);
        this.add(viewLeaderboard);

        playGame.setActionCommand("MAIN GAME");
        playGame.addActionListener(this);

        playCustom.setActionCommand("CUSTOM GAME");
        playCustom.addActionListener(this);

        viewLeaderboard.setActionCommand("VIEW LEADERBOARD");
        viewLeaderboard.addActionListener(this);
    }

    /**
     * Upon pressing the play, custom game, or leaderboard button, the user is directed
     * to its specific screen.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        outputBoundary.getCurrPanel(this);
        outputBoundary.changePanelTo(e.getActionCommand());
    }
}