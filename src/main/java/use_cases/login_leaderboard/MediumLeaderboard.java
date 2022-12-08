package use_cases.login_leaderboard;

import entities.login_leaderboard.User;
import java.util.Comparator;

/**
 * Generate the top 10 scores for the medium mode.
 */
public class MediumLeaderboard implements Comparator<User> {

    /**
     * Compare the medium-level scores of the two users.
     * @param a : User a
     * @param b : User b
     */
    public int compare(User a, User b)
    {
        return b.getMediumScore() - a.getMediumScore();
    }
}