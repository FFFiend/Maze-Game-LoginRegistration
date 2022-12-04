package user_interface.login_leaderboard;

import use_cases.default_game.IGamePanelInputBoundary;
import user_interface.default_game.GlobalFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

/**
 * Allows the user to login, register, or view leaderboard.
 */
public class WelcomePanel extends Panel implements ActionListener, IPanelInputBoundary {

    public int state = 2;
    IPanelOutputBoundary outputBoundary;

    /**
     * Construct a new WelcomeScreen panel with fixed settings
     **/
    public WelcomePanel(IPanelOutputBoundary ob) {
        outputBoundary = ob;
        this.build();
        JLabel welcomeMessage = new JLabel("Welcome to Astromaze!");
        welcomeMessage.setBounds(300, 150, 350, 70);


        JButton userSignUp = new JButton("Sign Up");
        userSignUp.setBounds(270, 270, 70, 70);
        userSignUp.setSize(245, 30);


        JButton userLogIn = new JButton("Log In");
        userLogIn.setBounds(270, 360, 50, 50);
        userLogIn.setSize(245, 30);


        userSignUp.setActionCommand("Sign up");
        userLogIn.setActionCommand("Log in");

        labelSet.add(welcomeMessage);
        labelFormat(labelSet);
        this.add(welcomeMessage);

        this.add(userSignUp);
        this.add(userLogIn);

        userSignUp.addActionListener(this);
        userLogIn.addActionListener(this);
    }


    /**
     * Notifies the welcome window on whether to switch to
     * login or register screen.
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        //this.setVisible(false);
        if (Objects.equals(e.getActionCommand(), "Sign up")) {
            state = 0;
            outputBoundary.currPanel(this);
            outputBoundary.changeState();
        } else if (Objects.equals(e.getActionCommand(), "Log in")) {
            outputBoundary.changeState();
        }
    }
}