package world.event.random;

/*
    BenjaminWilcox
    Jul 28, 2017
    GNGH2
 */
public class DistantSoldiers extends CitizenEvent
{

    public DistantSoldiers()
    {
        name = "Soldiers Join";
        value = 3;
        cooldown = 20;
        message = "A group of lost soldiers from a distant land have joined you";
        resource = "soldier";
    }

    @Override
    public int execute(int i)
    {
        int temp = (i % value + 1);
        addCitizens(temp);
        console.append(message + ": " + resource + " + " + temp);
        return cooldown;
    }

}
