package gngh;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class AudioPlayer
{

    private String dir = "Sounds";
    private static AudioPlayer instance = null;

    private AudioPlayer()
    {

    }

    public static AudioPlayer getInstance()
    {
        if (instance == null)
        {
            instance = new AudioPlayer();
        }
        return instance;
    }

    public void playStartSound()
    {
        new Thread()
        {
            public void run()
            {
                MediaPlayer player;
                new javafx.embed.swing.JFXPanel();
                String uriString = new File(dir + "\\" + "Computer_Start-Up-Your_Mom-1280862923.wav").toURI().toString();
                player = new MediaPlayer(new Media(uriString));
                player.play();
            }
        }.start();

    }

    public void playBing()
    {
        MediaPlayer player;
        new javafx.embed.swing.JFXPanel();
        String uriString = new File(dir + "\\" + "A-Tone-His_Self-1266414414.wav").toURI().toString();
        player = new MediaPlayer(new Media(uriString));
        player.play();
    }

}
