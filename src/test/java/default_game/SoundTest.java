package default_game;

import entities.default_game.Sound;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertThrows;

public class SoundTest {
    /**
     * Test playSE with an invalid input.
     */
    @Test
    public void invalidPlaySE() {
        Sound sound = new Sound();
        assertThrows(NullPointerException.class,
                ()->{
                    sound.playSE(-1);
                });
    }
}
