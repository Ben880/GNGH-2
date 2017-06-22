package gui.BackEnd;

import world.event.UserCreatedEvent;

/*
    BenjaminWilcox
    Jun 19, 2017
    GNGH_2
 */
public class WorldHandler
{

    UserCreatedEvent event = new UserCreatedEvent();
    SelectedTile selected = new SelectedTile();

    public WorldHandler()
    {

    }

    public void buttonClick(String s)
    {
        System.out.println("WorldHandler recived button click: " + s);
        if (s.equalsIgnoreCase("attack"))
        {
            event.create(selected.getSelected(), 1);
        } else if (s.equalsIgnoreCase("scout"))
        {
            event.create(selected.getSelected(), 0);
        } else if (s.equalsIgnoreCase("forage"))
        {
            event.create(selected.getSelected(), 2);
        }
    }

}
