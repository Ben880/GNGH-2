package util;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class Sound
{

    private MediaPlayer player;

    Sound(String file)
    {
        new javafx.embed.swing.JFXPanel();
        String uriString = new File("Sounds\\" + file).toURI().toString();
        player = new MediaPlayer(new Media(uriString));
    }

    public void play()
    {
        player.stop();
        player.play();
    }

}
