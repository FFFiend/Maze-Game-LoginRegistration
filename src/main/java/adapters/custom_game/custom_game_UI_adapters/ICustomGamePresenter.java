package adapters.custom_game.custom_game_UI_adapters;

public interface ICustomGamePresenter {

    default void callCustomGamePanel() {
    }
    default void callCustomGamePanel(String panelName) {
    }
    default void createTempMaze(){
    }
}
