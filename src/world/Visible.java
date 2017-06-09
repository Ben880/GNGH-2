package world;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class Visible
{

    private boolean biome = false;
    private boolean stats = false;

    public boolean isBiomeVisible()
    {
        return biome;
    }

    public void setBiomeVisible(boolean biome)
    {
        this.biome = biome;
    }

    public boolean isStatsVisible()
    {
        return stats;
    }

    public void setStatsVisible(boolean stats)
    {
        this.stats = stats;
    }

    public void setAllVisible(boolean b)
    {
        biome = b;
        stats = b;
    }

}
