package use_cases.default_game;

import java.io.IOException;

/**
 * The input boundary that is implemented by the use case interactor UpdatePlayer.
 */
public interface IGamePanelInputBoundary {

    /**
     * Execute the given keycode.
     *
     * @param keycode user keyboard input
     */
    void execute(int keycode) throws IOException;
}
