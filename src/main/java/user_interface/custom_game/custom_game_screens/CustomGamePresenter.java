package user_interface.custom_game.custom_game_screens;

import adapters.custom_game.custom_game_UI_adapters.ICustomGamePresenter;
import java.util.Objects;

public class CustomGamePresenter implements ICustomGamePresenter, ICustomGamePanel {

    /**
     * Call the constructors of one of the custom game screens
     * <p>
     * The screen options are: CustomGameMainScreen, CustomGameInitializerScreen, CustomGameEditorScreen
     * and customGameInvalidWarnScreen (only a popup)
     */
    @Override
    public void callCustomGameScreen(String screenName) {
        if (Objects.equals(screenName, "CustomGameMainScreen")){
            new CustomGameMainPanel();
        }
        else if (Objects.equals(screenName, "CustomGameInitializerScreen")){
            new CustomGameInitializerPanel();
        }
        else if (Objects.equals(screenName, "CustomGameEditorScreen")){
            new CustomGameEditorPanel();
        }
        else if (Objects.equals(screenName, "customGameInvalidWarnScreen")){
            System.out.println("To do!");
            //TODO display a popup with back buttons
        }
        else {
            System.out.println("To do!");
            //TODO throw an error
        }
    }

    /**
     * Overloaded version of the above method allowing the main custom game screen to be the default should no parameter
     * be provided
     */
    @Override
    public void callCustomGameScreen() {
        new CustomGameMainPanel();
    }


    /**
     * Create a TempMaze object to store a custom maze while it is being made
     */
    @Override
    public void createTempMaze(){
        //void until the TempMaze class created
    }

}