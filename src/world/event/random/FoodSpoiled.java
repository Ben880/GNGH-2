package world.event.random;

/*
    BenjaminWilcox
    Jul 30, 2017
    GNGH2
 */
public class FoodSpoiled extends ResourceEvent
{

    public FoodSpoiled()
    {
        name = "Rotton Food";
        value = 1;
        cooldown = 30;
        message = "Someone has discovered that some of the stored food is spoiled";
        resource = "food";
    }

    public int execute(int i)
    {
        int temp = (i * 5 * -1);
        addResource(temp);
        console.append(message + ": " + resource + " + " + temp);
        return cooldown;
    }

}
