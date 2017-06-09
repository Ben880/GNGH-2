package conditions;

import gui.main.ConsoleHandler;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class LoseCondition
{

    DayCondition day = new DayCondition();
    FoodCondition food = new FoodCondition();
    PeopleCondition people = new PeopleCondition();
    boolean lost = false;

    public LoseCondition()
    {

    }

    public void dayChange(int d)
    {
        if (day.compare(d) || food.compare() || people.compare())
            triggerLoss();
    }

    private void triggerLoss()
    {
        ConsoleHandler console = new ConsoleHandler();
        if (!lost)
            console.append("you lost :(   lukily for you we havent implimented this yet");
        lost = true;

    }

}
