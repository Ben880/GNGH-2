package world.event.random;

import gui.main.UpdateGUI;
import player.citizens.CitizenHolder;

/*
    BenjaminWilcox
    Jul 30, 2017
    GNGH2
 */
public class CitizenEvent extends RandomEvent
{

    private static CitizenHolder citizens = new CitizenHolder();

    public void addCitizens(int i)
    {
        citizens.getCitizen(resource).addCitizen(i);
        new UpdateGUI().update();
    }

}
