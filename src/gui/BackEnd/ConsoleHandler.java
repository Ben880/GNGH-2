package gui.BackEnd;

import gui.main.Console;
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

    //holds static console class for use by other classes
    //console constructor passes its instance
    public void initialize(Console s)
    {
        console = s;
    }

    //returns console not sure if this is used
    public Console console()
    {
        return console;
    }

    //plays sound when classes pass string to be appended to feed
    public void append(String string)
    {
        console.append(string);
        sound.playBing();
    }

}
