package render;

import cell.CellHolder;
import util.Location;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class RenderTiles
{

    CellHolder cell = new CellHolder();
    RenderTile render = new RenderTile();
    RenderFog fog = new RenderFog();

    public RenderTiles()
    {
    }

    public void render()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                if (cell.getCell(x, y).visible().isBiomeVisible() || cell.fog == false)
                {
                    render.render(x, y);
                } else
                {
                    fog.render(x, y);
                }
            }
        }
    }

    public void renderAll()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                render.render(x, y);
            }
        }
    }

    public void renderSquare(int x, int y)
    {
        render.render(x, y);
        render.render(x - 1, y - 1);
        render.render(x, y - 1);
        render.render(x + 1, y - 1);
        render.render(x + 1, y);
        render.render(x + 1, y + 1);
        render.render(x, y + 1);
        render.render(x - 1, y + 1);
        render.render(x - 1, y);
    }

    public void renderSquare(Location l)
    {

    }

}
