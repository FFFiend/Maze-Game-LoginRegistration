package adapters.login_leaderboard;

import use_cases.login_leaderboard.IRegisterUserOutputBoundary;

import javax.swing.*;


/***
 * The register use case presenter that aids in telling us whether
 * the registry was successful or not.
 */
public class RegisterUserPresenter implements IRegisterUserOutputBoundary {

    /***
     * Displays a simple message pertaining to what the appropriate output is.
     * @param u the response message, letting the user know if they've been
     *          registered, invalid password, etc.
     */
    @Override
    public void PrepareView(String u) {
        JOptionPane.showMessageDialog(null, u);
    }
}
