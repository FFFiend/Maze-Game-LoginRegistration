package use_cases.login_leaderboard;
import entities.login_leaderboard.User;

/**
 * Generate the top 10 scores for the easy mode.
 */
public class EasyLeaderboard extends LeaderboardGenerator {
    public EasyLeaderboard(User easy) {
        super(easy);
    }

    @Override
    public int compareTo(User b) {
        return this.a.getEasyScore() - b.getEasyScore();
    }
}
