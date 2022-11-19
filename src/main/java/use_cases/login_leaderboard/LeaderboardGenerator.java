package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeaderboardGenerator {
    /**
     * Storing the sorted easy-level scores.
     */
    private final ArrayList<User> EASY = new ArrayList<>();
    /**
     * Storing the sorted medium-level scores.
     */
    private final ArrayList<User> MEDIUM = new ArrayList<>();
    /**
     * Storing the sorted hard-level scores.
     */
    private final ArrayList<User> HARD = new ArrayList<>();
    /**
     * A Map of all previous users. Mapping the username to the user.
     */
    private Map<String, User> users = new HashMap<>();

    /**
     * Updating the map with the previous users.
     * @param users : A map of all precious users.
     */
    public void setUsers(Map<String, User> users){
        this.users = users;
    }

    /**
     * Updating and sorting the easy-level scores.
     * @return : A sorted array list of User objects, sorted by Users easy scores
     */
    public ArrayList<User> sortEasy() {
        EASY.addAll(users.values());
        EASY.sort(new EasyLeaderboard());
        return EASY;
    }

    /**
     * Updating and sorting the medium-level scores.
     * @return : A sorted array list of User objects, sorted by Users medium scores
     */
    public ArrayList<User> sortMedium() {
        MEDIUM.addAll(users.values());
        MEDIUM.sort(new MediumLeaderboard());
        return MEDIUM;
    }

    /**
     * Updating and sorting the hard-level scores.
     * @return : A sorted array list of User objects, sorted by Users hard scores
     */
    public ArrayList<User> sortHard() {
        HARD.addAll(users.values());
        HARD.sort(new HardLeaderboard());
        return HARD;
    }
}