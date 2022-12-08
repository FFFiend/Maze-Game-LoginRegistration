package use_cases.login_leaderboard;

import java.util.ArrayList;

/**
 * Note: FileUser can access the items of the CSV file due to dependency inversion.
 */
public interface IFileInputBoundary {
    ArrayList<ArrayList<String>> readFile();
}