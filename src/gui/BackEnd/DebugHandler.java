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

    CellHolder cell = new CellHolder();
    RenderTiles render = new RenderTiles();

    public DebugHandler()
    {

    }

    public void buttonPress(String action)
    {
        System.out.println("Debug action: " + action);
        if (action.equalsIgnoreCase("Toggle Fog"))
        {
            cell.toggleFog();
            render.render();
        }
    }

}
