package adapters.login_leaderboard;
import use_cases.login_leaderboard.ILoginUserOutputBoundary;

import javax.swing.*;

/**
 * Login User Presenter.
 */
public class LoginUserPresenter implements ILoginUserOutputBoundary {

    public boolean check;
    /**
     * Displays a simple message of whether the user succeeded in
     * logging in or not.
     *
     * @param j the response message.
     */
    @Override
    public void PrepareView(String j){
        JOptionPane.showMessageDialog(null,j);

    }
}