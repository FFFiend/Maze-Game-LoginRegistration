package user_interface.login_leaderboard;

public interface IPanelOutputBoundary {
    void changeState();
    void setPanel(Panel panel);

    void currPanel(Panel panel);
}
