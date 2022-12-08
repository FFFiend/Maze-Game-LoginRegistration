package default_game;

import use_cases.login_leaderboard.IFileOutputBoundary;

/**
 * an IGamePanelOutputBoundary implementation for testing only
 */
public class TestFileOutputBoundary implements IFileOutputBoundary {
    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void updateNewUser(String name, String email, String password) {
    }

    @Override
    public void updateScore(int score, String level, String username) {
    }
}
