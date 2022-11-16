package adapters.login_leaderboard;

import entities.login_leaderboard.User;
import use_cases.login_leaderboard.EasyLeaderboard;
import use_cases.login_leaderboard.FileUser;

import java.io.IOException;
import java.util.Arrays;

/**
 * Transforms the information from all three leaderboards into a viewable format.
 */
public class LeaderboardPresenter {
    FileUser users = new FileUser();

    public EasyLeaderboard[] generateTopEasy() throws IOException {
        users.prevUsers();
        int len = (users.getuserData().values()).size();
        EasyLeaderboard[] easyScore = new EasyLeaderboard[len];

        int i = 0;
        for (User key: users.getuserData().values()) {
            easyScore[i] = new EasyLeaderboard(key);
            i ++;
        }

        Arrays.sort(easyScore);
        return easyScore;
    }
}
