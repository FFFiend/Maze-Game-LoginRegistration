package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

public class UpdateScore {
    private final IFileOutput UPDATECSV;

    public UpdateScore(IFileOutput updatecsv) {
        UPDATECSV = updatecsv;
    }

    public void checkUser(User user){
    }
}