package gngh;

/*
    BenjaminWilcox
    Nov 27, 2016
    GNGH_2
 */
public class ConsoleHandler
{

    AudioPlayer sound;
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
