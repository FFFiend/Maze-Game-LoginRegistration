package adapters.custom_game;

import entities.default_game.MazeInfo;
import use_cases.custom_game.custom_game_file_management.CustomGameValidator;
import use_cases.custom_game.custom_game_file_management.ICustomGameFileManager;

/**
 * A boundary for CustomGameValidator so the input manager can access it
 */
public class ValidatorAdapter {
    private final CustomGameValidator validator;

    public ValidatorAdapter() {
        validator = new CustomGameValidator();
    }

    /**
     * Calls and sends a maze to the verifier. If it is valid, it calls the presenter to return the User to the custom
     * game main menu. If not, it shows the user a panel warning that their input was invalid.
     */
    public boolean verifyEditorInput(ICustomGameFileManager fileManager, ICustomGamePresenter presenter) {
        if (validator.verifyMaze(fileManager)) {
            presenter.callCustomGamePanel("CustomGameMainPanel");
            presenter.callCustomPopup("Maze stored successfully!");
            return true;
        }
        else {
            presenter.callCustomPopup("This maze needs at least one black hole and at least one escape pod to be solvable. ", "CustomGameEditorPanel" );
            return false;
        }
    }

    /**
     * Calls and sends maze initializer values to the verifier. If it is valid, it calls the presenter to take the
     * User to the editor. If not, it shows the user a panel warning that their input was invalid.
     */
    public boolean verifyInitializerInput(ICustomGameFileManager fileManager, ICustomGamePresenter presenter, ICustomInitializerInput initializer) {
        String mazeName = initializer.getMazeName();
        CustomGameValidator validator = new CustomGameValidator();

        if (!validator.verifyName(mazeName, fileManager)) {
            presenter.callCustomPopup("That name is already taken!", "CustomGameInitializerPanel" );
            return false;
        }
        else { //if more options are included in the initializer, more checks will be added
            //sends in constants as parameters in case customizing grid sizes is a feature added in the future
            TempMazeAdapter.prepareTempMaze(mazeName, MazeInfo.getMaxMazeRow(), MazeInfo.getMaxMazeCol(), MazeInfo.getTileSize());
            presenter.callCustomGamePanel("CustomGameEditorPanel");
            return true;
        }
    }
}