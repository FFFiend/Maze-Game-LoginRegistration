package user_interface.custom_game.custom_game_screens;

class CustomGameMainPanel implements ICustomGamePanel {
    //extends Screens

    /**
     * The first screen to be displayed on entering the custom maze section. Shows a list of custom mazes and a button
     * to take the user to the maze editor
     */
    protected CustomGameMainPanel (){
        //use Screens' methods to draw and CustomGameScreenInterface for the features specific to custom game screens
    }

    /**
     * Display a selection of custom mazes and a search bar
     */
    public void listCustomMazes(){
    }

    /**
     * Display all the actions a user can take involving custom mazes
     * Currently this is only creating them
     */
    public void displayCustomOptions(){
    }
}