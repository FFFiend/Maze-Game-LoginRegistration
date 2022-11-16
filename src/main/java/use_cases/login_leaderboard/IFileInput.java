package use_cases.login_leaderboard;

/**
 * FileUser can access the items of the CSV file due to dependency inversion.
 */
public interface IFileInput {
    String filePath();
}