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
        this.build();
        JLabel askUserName = new JLabel("Please enter your username");
        // check if user already exists, if not continue
        askUserName.setBounds(270, 30, 450, 70);
        askUserName.setForeground(this.TEXT_COLOR);
        askUserName.setFont(this.TEXT_FONT);

        this.username = new JTextField(50);
        username.setBounds(160, 110, 450, 30);

        JLabel askEmail = new JLabel("Please enter your email");
        askEmail.setBounds(270, 160, 450, 70);
        askEmail.setForeground(this.TEXT_COLOR);
        askEmail.setFont(this.TEXT_FONT);


        this.email = new JTextField(50);
        email.setBounds(160, 240, 450, 30);

        JLabel askPassword = new JLabel("Please enter your password.");
        askPassword.setBounds(270, 300, 450, 30);
        askPassword.setForeground(this.TEXT_COLOR);
        askPassword.setFont(this.TEXT_FONT);


        this.password = new JPasswordField(50);
        password.setBounds(160, 350, 450, 30);


        this.add(askUserName);
        this.add(username);
        this.add(askEmail);
        this.add(email);
        this.add(askPassword);
        this.add(password);

        JButton makeUser = new JButton("Create account");
        makeUser.setBounds(270, 400, 50, 50);
        makeUser.setSize(245, 30);
        makeUser.addActionListener(this);

        this.add(makeUser);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String passedUserName = username.getText();
        String passedEmail = email.getText();
        String passedPassword = String.valueOf(password.getPassword());
        System.out.println(passedPassword);
    }

    public void SignUp() {

    }

    public void IsValidUser() {

    }
}
