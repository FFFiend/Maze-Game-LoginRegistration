package user_interface.login_leaderboard;

import adapters.login_leaderboard.RegisterUserController;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Allows the user to create a new account by choosing a username and password.
 * Passes the username, password, and email to the register user controller.
 */
public class RegisterPanel extends Panel implements ActionListener {
    private final JTextField username;
    private final JPasswordField password;
    private final JTextField email;
    private String passedUsername;
    private String passedEmail;
    private String passedPassword;

    RegisterUserController registerUserController;

    public RegisterPanel(RegisterUserController registerUserController, IGlobalFrameOutputBoundary ob) {
        this.outputBoundary = ob;

        this.registerUserController = registerUserController;


        this.build();
        JLabel askUserName = new JLabel("Please enter your username");
        // check if user already exists, if not continue
        askUserName.setBounds(270, 30, 450, 40);


        this.username = new JTextField(50);
        username.setBounds(160, 90, 450, 30);

        JLabel askEmail = new JLabel("Please enter your email");
        askEmail.setBounds(270, 140, 450, 40);


        this.email = new JTextField(50);
        email.setBounds(160, 200, 450, 30);

        JLabel askPassword = new JLabel("Please enter your password.");
        askPassword.setBounds(270,250,450,40);

        this.password = new JPasswordField(50);
        password.setBounds(160, 310, 450, 30);

        labelSet.add(askUserName);
        labelSet.add(askEmail);
        labelSet.add(askPassword);

        labelFormat(labelSet);

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

        makeUser.setActionCommand("Reg Log in");

        this.add(makeUser);

        JButton re = new JButton("return to the welcome screen");
        re.setBounds(485,505,300,30);
        re.setSize(245,30);

        re.addActionListener(this);
        re.setActionCommand("wipe out");

        JOptionPane.showMessageDialog(null,"Your username must have at least" +
                "8 letters, one capital letter, one number and one special character.");

        this.add(re);
    }


    /**
     * Upon pressing the sign up button, the temporary username, email and password
     * are initialized for the current application user.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.passedUsername = username.getText();
        this.passedEmail = email.getText();
        this.passedPassword = String.valueOf(password.getPassword());
        if (!Objects.equals(passedUsername, "") && !Objects.equals(passedEmail, "")
                && !Objects.equals(passedPassword, "") && Objects.equals(e.getActionCommand(),"Reg Log in")){
            String s = registerUserController.performUseCase(passedUsername, passedEmail, passedPassword);
            if (Objects.equals(s,"yes")){
                outputBoundary.getCurrPanel(this);
                outputBoundary.changePanelTo(e.getActionCommand());
            }

        }
        if ((Objects.equals(passedUsername, "") || Objects.equals(passedEmail, "")
                || Objects.equals(passedPassword, "")) && Objects.equals(e.getActionCommand(),"Reg Log in")){

                JOptionPane.showMessageDialog(null, "Make sure to enter both a " +
                    "username and email before hitting register.");
        }
        if(Objects.equals(e.getActionCommand(),"wipe out")){
            outputBoundary.getCurrPanel(this);
            outputBoundary.changePanelTo(e.getActionCommand());
        }

    }
}
