package cell;

import biome.*;

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
    Biome biome;

    public Ownership getOwned()
    {
        return owned;
    }

    public Resources getResources()
    {
        return resources;
    }

    public Visible getVisible()
    {
        return visible;
    }

    public Biome getBiome()
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
    }
}
