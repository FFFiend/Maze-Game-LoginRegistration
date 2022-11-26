package adapters.login_leaderboard;

import use_cases.login_leaderboard.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Transforms the information from all three leaderboards into a viewable format.
 * Note: Add comments for instance variables
 * Note: Include the case when there are less than 10 users.
 */
public class LeaderboardPresenter {
    private final Map<String, Integer> EASYSCORES = new HashMap<>();
    private final Map<String, Integer> MEDSCORES = new HashMap<>();
    private final Map<String, Integer> HARDSCORES = new HashMap<>();
    private final LeaderboardGenerator Scores = new LeaderboardGenerator();
    private final IFileInput file;

    public LeaderboardPresenter(IFileInput file) {
        this.file = file;
    }

    /**
     * return the top 10 easy-level user scores.
     * @return : A hashmap mapping the top 10 users username to easy scores.
     */
    public Map<String, Integer> getTop10Easy() {
        for (int i = 0; i < 10; i ++){
            EASYSCORES.put(Scores.sortEasy().get(i).getUsername(),
                    Scores.sortEasy().get(i).getEasyScore());
        }
        return EASYSCORES;
    }

    /**
     * return the top 10 medium-level user scores.
     * @return : A hashmap mapping the top 10 users username to medium scores.
     */
    public Map<String, Integer> getTop10Med() {
        for (int i = 0; i < 10; i++){
            MEDSCORES.put(Scores.sortMedium().get(i).getUsername(),
                    Scores.sortMedium().get(i).getMediumScore());
        }
        return MEDSCORES;
    }

    /**
     * return the top 10 hard-level user scores.
     * @return : A hashmap mapping the top 10 users username to easy scores.
     */
    public Map<String, Integer> getTop10Hard() {

        for (int i = 0; i < 10; i++){
            HARDSCORES.put(Scores.sortHard().get(i).getUsername(),
                    Scores.sortHard().get(i).getHardScore());
        }
        return HARDSCORES;
    }

    /**
     * Update the leaderboard generator to include all users.
     */
    public void saveUsers(){
        FileUser users = new FileUser(file);
        Scores.setUsers(users.prevUsers());
    }
}