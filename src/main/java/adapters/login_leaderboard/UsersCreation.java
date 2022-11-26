package adapters.login_leaderboard;

import use_cases.login_leaderboard.FileUser;
import use_cases.login_leaderboard.IFileInput;
import use_cases.login_leaderboard.PreviousUsers;

import java.util.ArrayList;

public class UsersCreation {
    public final PreviousUsers prev = new PreviousUsers();

    /**
     * Update register, login, and leaderboard to include all previous users.
     */
    public void saveUsers(ArrayList<ArrayList<String>> data){
        IFileInput file = () -> data;
        FileUser user = new FileUser(file);

        prev.setUsers(user.prevUsers());
    }
}