package user_interface.login_leaderboard;
import adapters.login_leaderboard.LoginUserController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows user to enter their username and password. If both are correct, take the user to
 * the home screen. Else, allow the user to reset or re-enter their password.
 */
public class LoginPanel extends Panel implements ActionListener {

    private String username;
    private String password;

    private JTextField userField;
    private JPasswordField passwordField;

    LoginUserController loginUserController;
    /***
     * Constructs the login panel where the user can enter their username
     * and password.
     */
    public LoginPanel(LoginUserController loginUserController) {

        this.build();
        this.loginUserController = loginUserController;
        JLabel returnUserName = new JLabel("Please enter your username");
        returnUserName.setBounds(270, 100, 450, 40);


        userField = new JTextField(50);
        userField.setBounds(160, 160, 450, 30);

        JLabel returnPassword = new JLabel("Please enter your password");
        returnPassword.setBounds(270, 210, 450, 40);


        passwordField = new JPasswordField(50);
        passwordField.setBounds(160, 270, 450, 30);

        JButton logIn = new JButton("Log into your account");
        logIn.setBounds(250, 320, 50, 40);
        logIn.setSize(245, 30);


        labelSet.add(returnUserName);
        labelSet.add(returnPassword);
        labelFormat(labelSet);


        this.add(returnUserName);
        this.add(userField);
        this.add(returnPassword);
        this.add(passwordField);
        this.add(logIn);

        logIn.addActionListener(this);
    }


    /**
     * Upon pressing the login button, the entered username and password
     * are passed in for the current application user and the login use case
     * is initiated.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.username = userField.getText();
        this.password = String.valueOf(passwordField.getPassword());
        this.loginUserController.performUseCase(username, password);
    }
}
