package frameworks_and_drivers.login_leaderboard;
import adapters.login_leaderboard.LoginUserController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Allows user to enter their username and password. If both are correct, take the user to
 * the home screen. Otherwise, let the user know their login information is incorrect.
 */
public class LoginPanel extends Panel implements ActionListener {

    private String username;
    private final JTextField userField;
    private final JPasswordField passwordField;
    LoginUserController loginUserController;

    /**
     * Return the username entered by the user. This is used to keep track of the current user
     * playing the game.
     */
    public String getUsername(){
        return username;
    }

    /***
     * Constructs the login panel where the user can enter their username
     * and password.
     */
    public LoginPanel(LoginUserController loginUserController, IGlobalFrameOutputBoundary ob) {
        this.outputBoundary = ob;
        this.build();

        this.loginUserController = loginUserController;
        JLabel returnUserName = new JLabel("Please enter your username");
        returnUserName.setBounds(250, 100, 450, 40);

        userField = new JTextField(50);
        userField.setBounds(160, 160, 450, 30);

        JLabel returnPassword = new JLabel("Please enter your password");
        returnPassword.setBounds(250, 210, 450, 40);

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

        logIn.setActionCommand("Home Panel Launch");
        logIn.addActionListener(this);

        JButton re = new JButton("Welcome Screen");
        re.setBounds(485,505,300,30);
        re.setSize(245,30);

        re.addActionListener(this);
        re.setActionCommand("wipe out");

        this.add(re);
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
        String password = String.valueOf(passwordField.getPassword());
        if(!Objects.equals(username, "") && !password.equals("") &&
                Objects.equals(e.getActionCommand(),"Home Panel Launch")) {
            String result = this.loginUserController.performUseCase(username, password);
            if (Objects.equals(result, "yes")){
                outputBoundary.getCurrPanel(this);
                outputBoundary.changePanelTo(e.getActionCommand());
            }

        }
        if((Objects.equals(username, "") || password.equals("")) &&
                Objects.equals(e.getActionCommand(),"Home Panel Launch")) {

                JOptionPane.showMessageDialog(null, "Make sure you enter a valid" +
                    " username and password before hitting login.");
        }

        if(Objects.equals(e.getActionCommand(),"wipe out")){
            outputBoundary.getCurrPanel(this);
            outputBoundary.changePanelTo(e.getActionCommand());
        }
    }
}
