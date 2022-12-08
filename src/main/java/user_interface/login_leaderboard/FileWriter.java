package user_interface.login_leaderboard;

import use_cases.login_leaderboard.IFileOutputBoundary;

import java.io.*;
import java.io.FileReader;

/**
 * FileWriter allows the leaderboard and register use cases to update the CSV file.
 * When a new user is registered, file writer will add the user information.
 * When a new score is set by user, file writer will update the score.
 */
public class FileWriter implements IFileOutputBoundary {
    private final String filePath = "src/main/java/user_interface/login_leaderboard/data.csv";
    public static String username;

    /**
     * The current user playing the game, used to update the appropriate score.
     */
    @Override
    public String getUsername(){
        return username;
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

    /**
     * Replace the users score in the CSV file if the current stamina is lower
     * than the given one.
     *
     * @param score : Player stamina
     * @param level : Easy, medium, or hard
     * @param username : The current user's username
     * @throws IOException : Data csv file
     */
    @Override
    public void updateScore(int score, String level, String username) throws IOException {
        File tmp = File.createTempFile("tmp", "");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            BufferedWriter output;
            output = new BufferedWriter(new java.io.FileWriter(tmp, true));
            PrintWriter print = new PrintWriter(output);

            print.println(reader.readLine()); //header
            String currLine;
            String newLine = "";

            while((currLine = reader.readLine()) != null) {
                String[] values = currLine.split(",");
                if (values[0].equals(username)){
                    print.println(updateScoreHelper(score, level, newLine, values));
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

    /**
     * Helper method for updating score.
     */
    private String updateScoreHelper(int score, String level, String newLine, String[] values){
        switch (level) {
            case "EASY" :
                if (score > (Integer.parseInt(values[3]))){
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + score + "," + values[4] + "," + values[5]; }
                else {
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + values[3] + "," + values[4] + "," + values[5]; }
                break;
            case "MEDIUM" :
                if (score > (Integer.parseInt(values[4]))){
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + values[3] + "," + score + "," + values[5]; }
                else {
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + values[3] + "," + values[4] + "," + values[5]; }
                break;
            case "HARD" :
                if (score > (Integer.parseInt(values[5]))){
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + values[3] + "," + values[4] + "," + score; }
                else {
                    newLine = values[0] + "," + values[1] + "," + values[2]
                            + "," + values[3] + "," + values[4] + "," + values[5]; }
                break;
        }
        return newLine;
    }
}