package user_interface.login_leaderboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

/**
 * Allows the user to login, register, or view leaderboard.
 */
public class WelcomeGlobalFrame extends Panel implements ActionListener {

    public int state = 2;

    /**
     * Construct a new WelcomeScreen panel with fixed settings
     **/
    public WelcomeGlobalFrame(IGlobalFrameOutputBoundary ob) {
        outputBoundary = ob;
        this.build();

        JLabel welcomeMessage = new JLabel("Welcome to Astromaze!");
        welcomeMessage.setBounds(250, 150, 350, 70);

        JButton userSignUp = new JButton("Sign Up");
        userSignUp.setBounds(255, 270, 70, 70);
        userSignUp.setSize(245, 30);

        JButton userLogIn = new JButton("Log In");
        userLogIn.setBounds(255, 360, 50, 50);
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
            outputBoundary.getCurrPanel(this);
            outputBoundary.changePanelTo(e.getActionCommand());
        } else if (Objects.equals(e.getActionCommand(), "Log in")) {
            outputBoundary.getCurrPanel(this);
            outputBoundary.changePanelTo(e.getActionCommand());
        }
    }
}