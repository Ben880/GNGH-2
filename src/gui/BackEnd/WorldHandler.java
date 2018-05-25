package gui.BackEnd;

import world.event.UserCreatedEvent;

/*
    BenjaminWilcox
    Jun 19, 2017
    GNGH_2
 */
public class WorldHandler
{

    private UserCreatedEvent event = new UserCreatedEvent();
    private SelectedTile selected = new SelectedTile();

    //handles button clicks for world tab
    public WorldHandler()
    {

    }

    //executes action based on input string
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
        } else if (s.equalsIgnoreCase("chop wood"))
        {
            event.create(selected.getSelected(), "chop wood");
        }

    }

}
