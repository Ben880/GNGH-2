package util;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class SoundPlayer
{

    private static Sound start = new Sound("Computer_Start-Up-Your_Mom-1280862923.wav");
    private static Sound bing = new Sound("A-Tone-His_Self-1266414414.wav");

    public void playStart()
    {
        start.play();
    }

    public void playBing()
    {
        bing.play();
    }
}
