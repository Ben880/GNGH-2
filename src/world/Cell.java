package world;

import world.biome.Base;
import world.biome.Biome;
import world.biome.Desert;
import world.biome.Forest;
import world.biome.Mountian;
import world.biome.Plains;
import world.biome.Water;
import world.enemy.EnemyGroup;

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
    EnemyGroup enemy = new EnemyGroup();
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

    public EnemyGroup enemy()
    {
        return enemy;
    }

}
