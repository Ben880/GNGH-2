package world.event.random;

import gui.BackEnd.ConsoleHandler;

/*
    BenjaminWilcox
    Jul 28, 2017
    GNGH2
 */
public class RandomEvent
{

    //intentionally not left private (children classes need acess)
    int cooldown = 0;
    String name;
    String message;
    String resource;
    int value;
    ConsoleHandler console = new ConsoleHandler();

    public RandomEvent()
    {

    }

    public int execute(int i)
    {
        return cooldown;
    }

}
