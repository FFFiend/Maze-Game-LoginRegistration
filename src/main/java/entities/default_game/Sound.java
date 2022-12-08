package entities.default_game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * Class to store .wav files and play them with a method call.
 */
public class Sound {
    private Clip clip;
    private final URL[] soundURL = new URL[10];

    /**
     * Create Sound class with .wav files from resources
     */
    public Sound() {
        soundURL[0] = this.getClass().getResource("/music/pickup_1.wav");
        soundURL[1] = this.getClass().getResource("/music/pickup_2.wav");
        soundURL[2] = this.getClass().getResource("/music/stageClear.wav");
        soundURL[3] = this.getClass().getResource("/music/gameOver.wav");
    }

    /**
     * Set a .wav file to the Java Clip
     *
     * @param i integer that corresponds to a specific .wav file in soundURL list
     */
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    /**
     * Play the .wav file that corresponds to the integer input
     *
     * @param i integer input for setFile() method
     */
    public void playSE(int i) {
        setFile(i);
        clip.start();
    }
}
