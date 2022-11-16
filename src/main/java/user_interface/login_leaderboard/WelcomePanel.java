package user_interface.login_leaderboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Allows the user to login, register, or view leaderboard.
 */
public class WelcomePanel extends Panel implements ActionListener {


    /**
     * Construct a new WelcomeScreen panel with fixed settings
     **/
    public WelcomePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        JLabel welcomeMessage = new JLabel("Welcome to our Game!");
        JButton userSignUp = new JButton("Sign Up");
        JButton userLogIn = new JButton("Log In");
        welcomeMessage.setForeground(Color.red);
        welcomeMessage.setFont(new Font("Arial", Font.PLAIN, 17));

        this.add(welcomeMessage);
        this.add(userSignUp);
        this.add(userLogIn);

        userSignUp.addActionListener(this);
        userLogIn.addActionListener(this);


        this.setBackground(Color.darkGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}