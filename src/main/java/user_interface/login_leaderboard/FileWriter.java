package user_interface.login_leaderboard;

import use_cases.login_leaderboard.IFileInput;
import use_cases.login_leaderboard.IFileOutput;

import java.io.*;
import java.util.ArrayList;

/**
 * FileWriter allows the leaderboard and regitser use cases to update the CSV file.
 * When a new user is registered, file writer will add the user information.
 * When a new score is set by user, file writer will update the score.
 */
public class FileWriter implements IFileOutput {

    @Override
    public void updateNewUser(String name, String password, String email){
        String filePath = "C:\\Users\\arifa\\IdeaProjects\\course-project-group-93\\" +
                "src\\main\\java\\user_interface\\login_leaderboard\\data.csv";

        try {
            BufferedWriter output;
            output = new BufferedWriter(new java.io.FileWriter(filePath, true));
            PrintWriter print = new PrintWriter(output);

            String text = name + "," + password + "," + email + "," + "0" + "," + "0" + "," + "0";

            print.println(text);

            output.close();
            print.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}