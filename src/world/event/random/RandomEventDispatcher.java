package world.event.random;

import java.util.ArrayList;
import java.util.Random;

/*
    BenjaminWilcox
    Jul 28, 2017
    GNGH2
 */
public class RandomEventDispatcher
{

    private static Random rand = new Random();
    private static int cooldown = 0;
    private static ArrayList<RandomEvent> list = new ArrayList();

    public RandomEventDispatcher()
    {
        list.add(new TravelersJoin());
        list.add(new FoodSpoiled());
        list.add(new DistantSoldiers());
    }

    public void dayChange()
    {
        if (cooldown == 0)
        {
            if (rand.nextInt(100) > 97)
                chooseEvent();
        } else
        {
            cooldown -= 1;
        }
    }

    private void chooseEvent()
    {
        cooldown = list.get(rand.nextInt(list.size())).execute(rand.nextInt(100));
    }

}
