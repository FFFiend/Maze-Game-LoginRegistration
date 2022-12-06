package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows user to play, customize maze, or view leaderboard.
 */
public class HomePanel extends Panel implements ActionListener {

    public HomePanel(IGlobalFrameOutputBoundary ob) {
        this.outputBoundary = ob;
        this.build();

        JButton playGame = new JButton("Click to play the game");
        playGame.setBounds(250,100,50,50);
        playGame.setSize(245,30);

        JButton playCustom = new JButton("Click to play custom games");
        playCustom.setBounds(250,300,600,50);
        playCustom.setSize(245,30);


        JButton viewLeaderboard = new JButton("Click here to view the leaderboard");
        viewLeaderboard.setBounds(250,500,50,50);
        viewLeaderboard.setSize(245,30);


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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}