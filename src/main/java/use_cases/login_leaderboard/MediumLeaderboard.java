package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

/**
 * Generate the top 10 scores for the medium mode.
 */
public class MediumLeaderboard extends LeaderboardGenerator {
    public MediumLeaderboard(User medium) {
        super(medium);
    }

    @Override
    public int compareTo(User b) {
        return this.a.getMediumScore() - b.getMediumScore();
    }

}