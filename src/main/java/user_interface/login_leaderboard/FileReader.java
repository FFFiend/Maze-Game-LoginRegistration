package user_interface.login_leaderboard;

import use_cases.login_leaderboard.IFileInput;
import java.io.*;

/**
 * FileReader transforms the data in the CSV file into a readable format for the use cases.
 */
public class FileReader implements IFileInput {
    public String filePath() {
        String filePath = "./data.csv";
        File file = new File(filePath);

        if(file.isFile()) {
            return filePath;
        }

        return "File path does not exist";
    }

}
