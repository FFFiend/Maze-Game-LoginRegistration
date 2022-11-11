package use_cases.login_leaderboard;

public interface IDataAccessInterface {
    // Dependency Inversion: Allows the use case layer to access the CSV inorder to generate
    // the leaderboards and register new users.
}
