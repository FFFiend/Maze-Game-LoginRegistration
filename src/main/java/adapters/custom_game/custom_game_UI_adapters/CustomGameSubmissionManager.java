package adapters.custom_game.custom_game_UI_adapters;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_inner_file_management.CustomGameValidator;
import user_interface.custom_game.custom_game_panels.CustomGamePresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomGameSubmissionManager implements ActionListener {
    private final String PANEL;

    public CustomGameSubmissionManager(String panel){
        this.PANEL = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        verifyEditorInput(TempMaze.getMaze());
    }

    public void verifyEditorInput(EditorTile[][] maze){
        CustomGameValidator validator = new CustomGameValidator(maze);
        ICustomGamePresenter presenter = new CustomGamePresenter(); //Check!

        if (validator.verify()){
            //TODO should call main once that's implemented
            // and a popup to say the maze was written
            presenter.callCustomGamePanel("CustomGameEditorPanel");
        } else {
            presenter.callCustomGamePanel("customGameInvalidWarnPanel");
        }
    }
}
