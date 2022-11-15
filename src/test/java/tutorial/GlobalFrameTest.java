package tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user_interface.default_game.GlobalFrame;

public class GlobalFrameTest {

    @Test
    public void CreateFrameTest(){
        GlobalFrame testFrame = new GlobalFrame();
        Assertions.assertEquals(768, testFrame.FRAME_WIDTH);
        Assertions.assertEquals(576,testFrame.FRAME_HEIGHT);
    }
}
