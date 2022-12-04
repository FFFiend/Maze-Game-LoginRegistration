package user_interface.login_leaderboard;

public interface IGlobalFrameOutputBoundary {

    void setPanel(Panel panel);

    void getCurrPanel(Panel panel);

    void changePanelTo(String actionCommand);
}
