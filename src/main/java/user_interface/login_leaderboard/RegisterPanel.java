package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows the user to create a new account by choosing a username and password.
 * Passes the username, password, and email to the register user controller.
 */
public class RegisterPanel extends Panel implements ActionListener {
    public JTextField username;
    public JPasswordField password;
    public JTextField email;

    public RegisterPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        JLabel askUserName = new JLabel("Please enter your username");
        // check if user already exists, if not continue
        this.username = new JTextField(50);

        JLabel askEmail = new JLabel("Please enter your email");
        this.email = new JTextField(50);

        JLabel askPassword = new JLabel("Please enter your password.");
        this.password = new JPasswordField();


        this.add(askUserName);
        this.add(username);
        this.add(askEmail);
        this.add(email);
        this.add(askPassword);
        this.add(password);

        JButton makeUser = new JButton("Create account");
        makeUser.addActionListener(this);
        this.setBackground(Color.darkGray);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String passedUserName = username.getText();
        String passedEmail = email.getText();
        String passedPassword = String.valueOf(password.getPassword());
        System.out.println(passedPassword);
    }
}
