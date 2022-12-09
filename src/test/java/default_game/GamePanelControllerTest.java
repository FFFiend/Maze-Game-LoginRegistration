package default_game;

import adapters.default_game.GamePanelController;
import adapters.default_game.GamePanelPresenter;
import frameworks_and_drivers.login_leaderboard.FileWriter;
import org.junit.jupiter.api.Test;
import use_cases.default_game.MazeInteractor;
import use_cases.login_leaderboard.IFileOutputBoundary;

import java.awt.event.KeyEvent;

public class GamePanelControllerTest {
    @Test
    public void TestInput(){
        GamePanelPresenter presenter = new GamePanelPresenter();
        IFileOutputBoundary output = new FileWriter();

        MazeInteractor maze = new MazeInteractor(presenter, output);
        GamePanelController controller = new GamePanelController(maze);

        presenter.addKeyListener(controller);
        presenter.setFocusable(true);

        // controller.keyPressed(KeyEvent.VK_1);
    }
}
