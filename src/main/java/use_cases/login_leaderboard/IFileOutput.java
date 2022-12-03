package use_cases.login_leaderboard;

import java.io.IOException;

/**
 * Update the CSV file with a new user or score.
 */
public interface IFileOutput {
    void updateNewUser(String name, String email, String password);
    void updateScore(String score, String level, String username) throws IOException;
}