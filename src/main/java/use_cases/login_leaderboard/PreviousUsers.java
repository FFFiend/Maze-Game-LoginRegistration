package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.HashMap;

public class PreviousUsers {
    public HashMap<String, User> users = new HashMap<>();

    public void setUsers (HashMap<String, User> users){
        this.users = users;
    }

    public HashMap<String, User> getUsers(){
        return this.users;
    }
}