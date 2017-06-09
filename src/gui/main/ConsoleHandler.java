package gui.main;

import util.SoundPlayer;

/*
    BenjaminWilcox
    Nov 27, 2016
    GNGH_2
 */
public class ConsoleHandler
{

    private static SoundPlayer sound = new SoundPlayer();
    private static Console console;

    public void initialize(Console s)
    {
        console = s;
    }

    public Console console()
    {
        return console;
    }

    public void append(String string)
    {
        console.append(string);
        sound.playBing();
    }

}
