package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.HashMap;

public class PreviousUsers {
    /**
     * Hashmap of all users, maps username to user.
     */
    private HashMap<String, User> users = new HashMap<>();

    /**
     * Set the users after creating a hashmap from the CSV file.
     * @param users : A hashmap of the users in the CSV file
     */
    public void setUsers (HashMap<String, User> users){
        this.users = users;
    }

    /**
     * users getter method
     * @return : A hashmap of the users.
     */
    public HashMap<String, User> getUsers(){
        return this.users;
    }
}