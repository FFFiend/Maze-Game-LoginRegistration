package adapters.login_leaderboard;

import use_cases.login_leaderboard.FileUser;
import use_cases.login_leaderboard.IFileInputtBoundary;
import use_cases.login_leaderboard.PreviousUsers;

import java.util.ArrayList;

/**
 * Update register, login, and leaderboard use cases to include all previous users.
 */
public class UsersCreation {
    public final PreviousUsers PREV = new PreviousUsers();

    /**
     * Takes in a nested array list of the data from the CSV file, passes the data to file user to
     * create a hashmap of the previous users. Updates the setter in the PreviousUsers class, allowing
     * the use cases to access the users.
     * @param data : The data stored in the csv file, converted to a nested array list
     */
    public void saveUsers(ArrayList<ArrayList<String>> data){
        IFileInputtBoundary file = () -> data;
        FileUser user = new FileUser(file);

        PREV.setUsers(user.prevUsers());
    }
}