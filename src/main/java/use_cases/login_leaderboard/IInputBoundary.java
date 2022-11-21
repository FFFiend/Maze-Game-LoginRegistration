package use_cases.login_leaderboard;

public interface IInputBoundary {
    void setters(String username, String password, String email);
    void createUser();
}
