package gngh;

import java.awt.Color;

/*
    BenjaminWilcox
    Nov 13, 2016
    GNGH_2
 */
public class Pallet
{

    private static Pallet instance;
    Color forest = new Color(0, 100, 0);
    Color desert = new Color(255, 209, 114);
    Color base = Color.red;
    Color plains = Color.green;
    Color mountian = Color.gray;
    Color water = Color.blue;

    private Pallet()
    {

    }

    public static Pallet getInstance()
    {
        if (instance == null)
            instance = new Pallet();
        return instance;
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
