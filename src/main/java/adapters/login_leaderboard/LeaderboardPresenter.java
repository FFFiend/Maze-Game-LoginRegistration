package adapters.login_leaderboard;

import use_cases.login_leaderboard.EasyLeaderboard;
import use_cases.login_leaderboard.FileUser;
import use_cases.login_leaderboard.HardLeaderboard;
import use_cases.login_leaderboard.MediumLeaderboard;

import java.io.IOException;
import java.util.Arrays;

/**
 * Transforms the information from all three leaderboards into a viewable format.
 */
public class LeaderboardPresenter {
    /**
     * Create an array of user objects, sorted by their easy scores.
     */
    public EasyLeaderboard[] generateEasyScores() throws IOException {
        FileUser users = new FileUser();
        users.prevUsers();
        int len = (users.prevUsers().values().size());

        EasyLeaderboard[] easyScore = new EasyLeaderboard[len];

        int i = 0;
        for (String user : users.prevUsers().keySet()) {
            easyScore[i] = new EasyLeaderboard(users.prevUsers().get(user));
            i ++;
            assert (i <= users.prevUsers().values().size());
        }
        Arrays.sort(easyScore);
        return easyScore;
    }

    /**
     * Create an array of user objects, sorted by their medium scores.
     */
    public MediumLeaderboard[] generateMedScores() throws IOException {
        FileUser users = new FileUser();
        users.prevUsers();
        int len = (users.prevUsers().values()).size();

        MediumLeaderboard[] medScore = new MediumLeaderboard[len];

        int i = 0;
        for (String user : users.prevUsers().keySet()) {
            medScore[i] = new MediumLeaderboard(users.prevUsers().get(user));
            i ++;
            assert (i <= users.prevUsers().values().size());
        }
        Arrays.sort(medScore);
        return medScore;
    }
    /**
     * Create an array of user objects, sorted by their hard scores.
     */
    public HardLeaderboard[] generateHardScores() throws IOException {
        FileUser users = new FileUser();
        users.prevUsers();
        int len = (users.prevUsers().values()).size();

        HardLeaderboard[] hardScore = new HardLeaderboard[len];

        int i = 0;
        for (String user : users.prevUsers().keySet()) {
            hardScore[i] = new HardLeaderboard(users.prevUsers().get(user));
            i ++;
            assert (i <= users.prevUsers().values().size());
        }
        Arrays.sort(hardScore);
        return hardScore;
    }
}