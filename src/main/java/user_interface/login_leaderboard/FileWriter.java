package user_interface.login_leaderboard;

import use_cases.login_leaderboard.IFileOutput;

import java.io.*;
import java.io.FileReader;

/**
 * FileWriter allows the leaderboard and regitser use cases to update the CSV file.
 * When a new user is registered, file writer will add the user information.
 * When a new score is set by user, file writer will update the score.
 */
public class FileWriter implements IFileOutput {
    private final String filePath = "C:\\Users\\arifa\\IdeaProjects\\course-project-group-93\\" +
            "src\\main\\java\\user_interface\\login_leaderboard\\data.csv";

    @Override
    public String getUsername() {
        return PanelManager.username;
    }

    /**
     * Update data.csv to include a new row with the given information.
     * @param name : username
     * @param password : user password
     * @param email : user email
     */
    @Override
    public void updateNewUser(String name, String password, String email){

        try {
            BufferedWriter output;
            output = new BufferedWriter(new java.io.FileWriter(filePath, true));
            PrintWriter print = new PrintWriter(output);

            String text = name + "," + password + "," + email + "," + "0" + ","
                    + "0" + "," + "0";

            print.println(text);

            output.close();
            print.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateScore(int score, String level, String username) throws IOException {
        File tmp = File.createTempFile("tmp", "");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            BufferedWriter output;
            output = new BufferedWriter(new java.io.FileWriter(tmp, true));
            PrintWriter print = new PrintWriter(output);

            print.println(reader.readLine());

            String currLine;
            String newLine = "";

            while((currLine = reader.readLine()) != null) {
                String[] values = currLine.split(",");
                if (values[0].equals(username)){
                    switch (level) {
                        case "EASY" : newLine = values[0] + "," + values[1] + "," + values[2]
                                + "," + score + "," + values[4] + "," + values[5];
                        break;
                        case "MEDIUM" : newLine = values[0] + "," + values[1] + "," + values[2]
                                + "," + values[3] + "," + score + "," + values[5];
                        break;
                        case "HARD" : newLine = values[0] + "," + values[1] + "," + values[2]
                                + "," + values[3] + "," + values[4] + "," + score;
                        break;
                    }
                    print.println(newLine);
                }
                else {
                    print.println(currLine);
                }
            }

            print.close();
            output.close();
            reader.close();

            File old = new File(filePath);
            if (old.delete())
                tmp.renameTo(old);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}