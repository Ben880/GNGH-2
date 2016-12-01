package util;

import java.awt.Color;

/*
    BenjaminWilcox
    Nov 13, 2016
    GNGH_2
 */
public class TilePallet
{

    public static Color forest = new Color(0, 100, 0);
    public static Color desert = new Color(255, 209, 114);
    public static Color base = Color.red;
    public static Color plains = Color.green;
    public static Color mountian = Color.gray;
    public static Color water = Color.blue;

    public TilePallet()
    {

    }

    public Color biome(String s)
    {
        if (s == "plains")
            return plains;
        else if (s == "forest")
            return forest;
        else if (s == "mountian")
            return mountian;
        else if (s == "desert")
            return desert;
        else if (s == "water")
            return water;
        else if (s == "base")
            return base;
        return Color.yellow;
    }
}
