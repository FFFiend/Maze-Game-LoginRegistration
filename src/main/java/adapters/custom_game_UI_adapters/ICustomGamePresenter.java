package adapters.custom_game_UI_adapters;

public interface ICustomGamePresenter {

    //display method(s), awaiting HomeScreen implementation

    default void callCustomGameScreen() {
    }
    default void callCustomGameScreen(String screenName) {
    }
    default void createTempMaze(){
    }
}
