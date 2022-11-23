package use_cases.login_leaderboard;

/**
 * Login input boundary that takes in passed in username and password.
 */
public interface ILoginUserInputBoundary {

    /**
     * Abstract method to pass in relevant information.
     * @param username entered username.
     * @param password entered password.
     */
    void detailChecker(String username, String password);
}
