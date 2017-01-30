package render;

import biome.Biome;
import gui.Tiles;
import java.awt.Color;
import util.Location;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class Render
{

    static Tiles tiles;

    public void initialize(Tiles t)
    {
        tiles = t;
    }

    public void render(Location l, Biome b)
    {
        tiles.setColor(0, 0, new Color(0, 0, 0));
        tiles.setText(0, 0, "");
    }

}
