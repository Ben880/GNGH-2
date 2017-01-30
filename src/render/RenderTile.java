package render;

import cell.CellHolder;
import gngh.Tiles;
import util.Location;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class RenderTile
{

    static Tiles tile;
    CellHolder cell = new CellHolder();

    public RenderTile()
    {

    }

    public void initialize(Tiles tile)
    {
        this.tile = tile;
    }

    public void render(Location l)
    {
        tile.setColor(l.getX(), l.getY(), cell.getCell(l).biome().getColor());
        tile.setText(l.getX(), l.getY(), cell.getCell(l).biome().getText());
    }

    public void render(int x, int y)
    {
        try
        {
            tile.setColor(x, y, cell.getCell(x, y).biome().getColor());
            tile.setText(x, y, cell.getCell(x, y).biome().getText());
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
