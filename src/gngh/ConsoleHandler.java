package gngh;

import util.SoundPlayer;

/*
    BenjaminWilcox
    Nov 27, 2016
    GNGH_2
 */
public class ConsoleHandler
{

    SoundPlayer sound = new SoundPlayer();
    Console console;

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
