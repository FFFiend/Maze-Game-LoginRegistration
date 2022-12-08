package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a hashmap of all users in the csv file.
 */
public class FileUser {
    /**
     * Hashmap of pre-exsisting users, maps username to the user
     */
    private final HashMap<String, User> USERDATA = new HashMap<>();
    /**
     *  Create the IFileInput interface to use the readFile method
     */
    private final IFileInputtBoundary FILE;

    /**
     * Interface constructor
     * @param file : IFileInput Interface
     */
    public FileUser(IFileInputtBoundary file) {
        this.FILE = file;
    }

    /**
     * Create a hashmap using the nested array list. Each array stores the User values.
     * The first value in an array is the username.
     * @return : A Hashmap mapping username to User
     */
    public HashMap<String, User> prevUsers(){
        ArrayList<ArrayList<String>> info = FILE.readFile();

        for (ArrayList<String> row : info){
            String username = row.get(0);
            String password = row.get(1);
            String email = row.get(2);
            String easyScore = row.get(3);
            String medScore = row.get(4);
            String hardScore = row.get(5);

            int easy = Integer.parseInt(easyScore);
            int med = Integer.parseInt(medScore);
            int hard = Integer.parseInt(hardScore);

            User user = new User(username, password, email);

            user.setEasyScore(easy);
            user.setMediumScore(med);
            user.setHardScore(hard);

            USERDATA.put(username, user);
        }

        return USERDATA;
    }
}