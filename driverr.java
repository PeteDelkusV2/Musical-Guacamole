import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class driver {

    public static void main(String [] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        graphics testCase = new graphics();
        (new Thread(testCase)).start();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("mariachi.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
			  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		clip.start();
    }

}
