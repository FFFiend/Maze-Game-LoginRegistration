package use_cases.login_leaderboard;
import entities.login_leaderboard.User;

/**
 * Generate the top 10 scores for the hard mode.
 */
public class HardLeaderboard extends LeaderboardGenerator {
    public HardLeaderboard(User hard) {
        super(hard);
    }

    @Override
    public int compareTo(User b) {
        return this.a.getHardScore() - b.getHardScore();
    }

}
