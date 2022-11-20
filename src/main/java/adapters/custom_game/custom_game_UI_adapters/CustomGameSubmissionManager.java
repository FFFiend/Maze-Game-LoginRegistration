package adapters.custom_game.custom_game_UI_adapters;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_inner_file_management.CustomGameValidator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomGameSubmissionManager implements ActionListener {
    private final String PANEL;
    private final ICustomGamePresenter presenter;

    public CustomGameSubmissionManager(String panel, ICustomGamePresenter presenter){
        this.PANEL = panel;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        verifyEditorInput(TempMaze.getMaze());
    }

    public void verifyEditorInput(EditorTile[][] maze){
        CustomGameValidator validator = new CustomGameValidator(maze);
        //ICustomGamePresenter presenter = new CustomGamePresenter(); //Check!

        if (validator.verify()){
            //TODO should call main once that's implemented
            // and a popup to say the maze was written
            presenter.callCustomGamePanel("CustomGameEditorPanel");
        } else {
            presenter.callCustomGamePanel("customGameInvalidWarnPanel");
        }
    }
}
