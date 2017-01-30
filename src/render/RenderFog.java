package render;

import cell.CellHolder;
import gui.Tiles;
import java.awt.Color;
import util.Location;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class RenderFog
{

    CellHolder cell = new CellHolder();
    static Tiles tile;

    public RenderFog()
    {

    }

    public void initialize(Tiles tile)
    {
        this.tile = tile;
    }

    public void render(int x, int y)
    {
        tile.setColor(x, y, new Color(0, 0, 0));
        tile.setText(x, y, "");
    }

    public void render(Location l)
    {

    }

}
