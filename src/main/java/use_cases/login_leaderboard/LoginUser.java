package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

/**
 * Checks whether the entered username and password combination entered
 * is valid. Furthermore, displays a popup message notifying the user of
 * what the result is.
 */
public class LoginUser extends PreviousUsers implements ILoginUserInputBoundary {

    final ILoginUserOutputBoundary loginPresenter;
    private String username;
    private String password;

    public LoginUser(ILoginUserOutputBoundary loginPresenter){ this.loginPresenter = loginPresenter;}

    /**
     * Checks whether the entered username exists in the database, and whether
     * the password entered matches the one associated with said user, if they exist.
     * @param username entered username.
     * @param password entered password.
     */
    @Override
    public void detailChecker(String username, String password) {
        this.username = username;
        this.password = password;
        // TODO
        if (userExists() && pwdMatch()){
            loginPresenter.PrepareView("Welcome, please continue to the game.");
        }
        else{
            loginPresenter.PrepareView("Username password combination is invalid. " +
                    "If you are a returning user, please enter the correct password.");
        }
    }

    /**
     * Checks if user exists in the database.
     * @return whether they exist.
     */
    public boolean userExists(){
        return getUsers().containsKey(username);
    }

    /**
     *
     * @return whether the password matches it's username,
     * provided the user exists.
     */
    public boolean pwdMatch(){
        if (userExists()){
            User user = getUsers().get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }
}