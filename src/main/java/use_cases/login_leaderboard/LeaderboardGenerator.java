package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

abstract class LeaderboardGenerator implements Comparable<User> {
    User a;
    public LeaderboardGenerator(User a){
        this.a = a;
    }

}