package frameworks_and_drivers.login_leaderboard;

public interface IGlobalFrameOutputBoundary {

    void setPanel(Panel panel);

    void getCurrPanel(Panel panel);

    void changePanelTo(String actionCommand);
}