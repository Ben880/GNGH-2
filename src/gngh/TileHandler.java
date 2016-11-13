package gngh;

import java.awt.Color;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class TileHandler
{

    //needs to be iniitalized
    Tiles tiles;
    Info info;
    Pallet pallet;

    public TileHandler()
    {
        info = Info.getInstance();
        pallet = Pallet.getInstance();
    }

    public void initialize(Tiles t)
    {
        tiles = t;
    }

    public void drawFog()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            if (info.visible.getFog(x, y, info.visible.fog))
            {
                tiles.setColor(x, y, Color.black);
                tiles.setText(x, y, "");
            }
            i++;
            x++;
        }
    }

    public void dispBiome(int x, int y)
    {
        switch (info.visible.getBiome(x, y, false))
        {
            case 0:
                tiles.setText(x, y, ",.");
                tiles.setColor(x, y, Color.green);
                break;
            case 1:
                tiles.setText(x, y, "^");
                tiles.setColor(x, y, Color.gray);
                break;
            case 2:
                tiles.setText(x, y, "~");
                tiles.setColor(x, y, Color.blue);
                break;
            case 3:
                tiles.setText(x, y, "||");
                tiles.setColor(x, y, pallet.forest);
                break;
            case 4:
                tiles.setText(x, y, "_");
                tiles.setColor(x, y, pallet.desert);
                break;
            case -1:
                tiles.setText(x, y, "b");
                tiles.setColor(x, y, Color.red);
                break;
            default:
                break;
        }
        //info.visible.setBiomeVisible(x, y, true);
    } //end method

    public void dispBiomeSquare(int x, int y)
    {
        dispBiome(x, y);
        if (checkBiome(x - 1, y - 1))
            dispBiome(x - 1, y - 1);
        if (checkBiome(x, y - 1))
            dispBiome(x, y - 1);
        if (checkBiome(x + 1, y - 1))
            dispBiome(x + 1, y - 1);
        if (checkBiome(x + 1, y))
            dispBiome(x + 1, y);
        if (checkBiome(x + 1, y + 1))
            dispBiome(x + 1, y + 1);
        if (checkBiome(x, y + 1))
            dispBiome(x, y + 1);
        if (checkBiome(x - 1, y + 1))
            dispBiome(x - 1, y + 1);
        if (checkBiome(x - 1, y))
            dispBiome(x - 1, y);
    } //end method

    public void dispAllBiome()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            dispBiome(x, y);
            i++;
            x++;
        }
    } //end method

    public boolean checkBiome(int x, int y)
    {
        try
        {
            info.visible.getBiome(x, y, true);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    } //end method

    public void draw()
    {
        if (info.visible.fog)
        {
            dispAllBiome();
            drawFog();
        } else
        {
            dispAllBiome();
        }
    } //end method

    public void toggleFog()
    {
        if (info.visible.fog)
        {
            draw();
        } else
        {
            draw();
        }
    }
}
