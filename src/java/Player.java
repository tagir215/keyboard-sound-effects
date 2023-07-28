import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Player
{
	Player(){
		System.out.println("sound ok");
	}
	public void play(URL url) {
	    try {
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(20f * (float) Math.log10(0.4f));
	        clip.start();
	    } catch (Exception e) {
	        System.out.println("bruh");
	    }
	}
}