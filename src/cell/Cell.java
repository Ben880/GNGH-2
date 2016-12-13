package cell;

import biome.*;
import enemy.*;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class Cell
{

    Ownership owned = new Ownership();
    Resources resources = new Resources();
    Visible visible = new Visible();
    Enemy enemy;
    Biome biome;

    public Ownership owned()
    {
        return owned;
    }

    public Resources resources()
    {
        return resources;
    }

    public Visible visible()
    {
        return visible;
    }

    public Biome biome()
    {
        return biome;
    }

    public void setBiome(int i)
    {
        if (i == 0)
            biome = new Plains();
        else if (i == 1)
            biome = new Mountian();
        else if (i == 2)
            biome = new Water();
        else if (i == 3)
            biome = new Forest();
        else if (i == 4)
            biome = new Desert();
        else if (i == -1)
            biome = new Base();
    }

    public Enemy enemy()
    {
        return enemy;
    }

    public void setEnemy(int i)
    {
        switch (i)
        {
            case -1:
                enemy = new None();
                break;
            case 0:
                enemy = new Default();
                break;
            case 1:
                enemy = new Bandits();
                break;
            case 2:
                enemy = new Bear();
                break;
            case 3:
                enemy = new Boar();
                break;
            case 4:
                enemy = new Dragon();
                break;
            case 5:
                enemy = new Gaben();
                break;
            case 6:
                enemy = new Giant();
                break;
            case 7:
                enemy = new Mamoth();
                break;
            case 8:
                enemy = new Outlaws();
                break;
            case 9:
                enemy = new Savages();
                break;
            case 10:
                enemy = new Witches();
                break;
            default:
                enemy = new Default();
                break;

        }
    }
}
