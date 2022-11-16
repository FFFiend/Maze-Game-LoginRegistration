package use_cases.login_leaderboard;

import entities.login_leaderboard.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Creates a hashmap of User objects of the all users in the csv file.
 */
public class FileUser {
    private final Map<String, User> USERDATA = new HashMap<>();
    private IFileInput file;


    public void prevUsers() throws IOException {
        String csvPath = file.filePath();
        File csvFile = new File(csvPath);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("email", 2);
        headers.put("easyScore", 3);
        headers.put("medScore", 4);
        headers.put("hardScore", 5);

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");

            String username = String.valueOf(col[headers.get("username")]);
            String password = String.valueOf(col[headers.get("password")]);
            String email = String.valueOf(col[headers.get("email")]);
            String easyScore = String.valueOf(col[headers.get("easyScore")]);
            String medScore = String.valueOf(col[headers.get("medScore")]);
            String hardScore = String.valueOf(col[headers.get("hardScore")]);

            int easy = Integer.parseInt(easyScore);
            int med = Integer.parseInt(medScore);
            int hard = Integer.parseInt(hardScore);


            User user = new User(username, password);
            user.setEmail(email);
            user.setEasyScore(easy);
            user.setMediumScore(med);
            user.setHardScore(hard);

            USERDATA.put(username, user);
            }

            reader.close();
        }

    public Map<String, User> getuserData() {
        return USERDATA;
    }
}

