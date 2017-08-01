package gui.BackEnd;

import gui.main.UpdateGUI;
import player.citizens.CitizenHolder;
import world.CellHolder;
import world.render.RenderTiles;

/*
    BenjaminWilcox
    Jul 25, 2017
    GNGH2
 */
public class DebugHandler
{

    private CellHolder cell = new CellHolder();
    private RenderTiles render = new RenderTiles();
    private CitizenHolder citizens = new CitizenHolder();

    //handles button clicks in debug tab
    public DebugHandler()
    {

    }

    //inputs button text and executs proper action
    public void buttonPress(String action)
    {
        System.out.println("Debug action: " + action);
        if (action.equalsIgnoreCase("Toggle Fog"))
        {
            cell.toggleFog();
            render.render();
        }
        if (action.equalsIgnoreCase("Set Biome"))
        {

        }
        if (action.equalsIgnoreCase("Print Citizens"))
        {
            citizens.printCitizens();
        }
        if (action.equalsIgnoreCase("Update GUI"))
        {
            new UpdateGUI().update();
        }
        //more if statements here
    }

}
