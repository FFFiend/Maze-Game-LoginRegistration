package use_cases.login_leaderboard;

/**
 * Update the CSV file with a new user or
 */
public interface IFileOutput {
    void updateNewUser(String name, String email, String password);
}