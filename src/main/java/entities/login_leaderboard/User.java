package entities.login_leaderboard;

/**
 * The user stores a user's name, password, email, and the quickest
 * easy, medium, hard scores.
 */
public class User {
    private final String USERNAME;
    private final String PASSWORD;
    private String EMAIL;
    private int easyScore;
    private int mediumScore;
    private int hardScore;

    public User(String username, String password) {
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    public String getUsername() {
        return this.USERNAME;
    }

    public String getPassword() {
        return this.PASSWORD;
    }

    public String getEmail() {
        return this.EMAIL;
    }

    public void setEmail(String email) {this.EMAIL = email;}

    public int getEasyScore() {
        return this.easyScore;
    }

    public void setEasyScore(int score) {
        this.easyScore = score;
    }

    public int getMediumScore() {
        return this.mediumScore;
    }

    public void setMediumScore(int score) {
        this.mediumScore = score;
    }

    public int getHardScore() {
        return this.hardScore;
    }

    public void setHardScore(int score) {
        this.hardScore = score;
    }

}
