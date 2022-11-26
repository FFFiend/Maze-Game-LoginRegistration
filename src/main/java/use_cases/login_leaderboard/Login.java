package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.HashMap;
import java.util.Map;

public class Login implements IInputBoundaryLogin {
    private Map<String, User> users = new HashMap<>();

    public void setUsers(Map<String, User> users){
        this.users = users;
    }

    public boolean exsistingUser(String username, String password){
        return false;
    }
}
