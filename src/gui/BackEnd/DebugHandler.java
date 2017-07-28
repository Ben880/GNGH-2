package gui.BackEnd;

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
        //more if statements here
    }

}
