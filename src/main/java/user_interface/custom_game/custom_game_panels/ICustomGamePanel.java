package user_interface.custom_game.custom_game_panels;

/**
 * Common UI methods for the custom game section
 */
interface ICustomGamePanel {

    /**
     * draws a button on the panel that cancels all current tasks and returns the user to the custom game main menu
     * @param x the x positioning on the panel
     * @param y the y positioning on the panel
     */
    default void returnToCustomMainButton(int x, int y){

    }

    /**
     * default positioning is the bottom right of the panel
     */
    default void returnToCustomMainButton(){

    }
}
