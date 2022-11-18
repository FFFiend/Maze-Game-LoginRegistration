package user_interface.custom_game.custom_game_panels;

class CustomGameMainPanel implements ICustomGamePanel {
    //extends Panels

    /**
     * The first panel to be displayed on entering the custom maze section. Shows a list of custom mazes and a button
     * to take the user to the maze editor
     */
    protected CustomGameMainPanel (){
        //use Panel's methods to draw and CustomGamePanelInterface for the features specific to custom game panels
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