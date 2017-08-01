package world.event.random;

/*
    BenjaminWilcox
    Jul 28, 2017
    GNGH2
 */
public class TravelersJoin extends CitizenEvent
{

    public TravelersJoin()
    {
        name = "Travelers Join";
        value = 10;
        cooldown = 10;
        message = "A group of travelers have decided to join you";
        resource = "citizen";
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
