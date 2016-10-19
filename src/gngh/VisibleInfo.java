package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class VisibleInfo
{

    public boolean fog = true;
    private int[][] biome = new int[20][20];
    private String[][] biomeName = new String[20][20];
    private double[][] fertility = new double[20][20];
    private double[][] mining = new double[20][20];
    private double[][] lumber = new double[20][20];
    private boolean[][] biomeVisible = new boolean[20][20];
    private boolean[][] statsVisible = new boolean[20][20];
    public static int count = 0;

    private static VisibleInfo instance = null;

    private VisibleInfo()
    {

    }

    public static VisibleInfo getInstance()
    {
        if (instance == null)
        {
            instance = new VisibleInfo();
        }
        return instance;
    }

    //return strings
    public String getBiomeString(int x, int y)
    {
        return biomeName[x][y];
    }

    //return numbers
    public int getBiome(int x, int y, boolean override)
    {
        if (override || biomeVisible[x][y])
            return (biome[x][y]);
        else
            return -2;
    }

    public boolean getFog(int x, int y)
    {
        return fog;
    }

    public boolean getFog(int x, int y, boolean dispFog)
    {
        if (biomeVisible[x][y])
            return false;
        else if (!dispFog)
            return false;
        else
            return true;
    }

    public boolean getBiomeVisible(int x, int y) //opposite of getFog
    {
        return biomeVisible[x][y];
    }

    public boolean getStatsVisible(int x, int y)
    {
        return statsVisible[x][y];
    }

    public double getFertility(int x, int y)
    {
        return fertility[x][y];

    }

    public double getMining(int x, int y)
    {
        return mining[x][y];

    }

    public double getLumber(int x, int y)
    {
        return lumber[x][y];
    }

    //settin numbers
    public void setBiome(int x, int y, int i)
    {
        biome[x][y] = i;
        switch (i)
        {
            case 0:
                biomeName[x][y] = "Plains";
                break;
            case 1:
                biomeName[x][y] = "Mountian";
                break;
            case 2:
                biomeName[x][y] = "Water";
                break;
            case 3:
                biomeName[x][y] = "Forest";
                break;
            case 4:
                biomeName[x][y] = "Desert";
                break;
            case -1:
                biomeName[x][y] = "Base";
                break;
            default:
                biomeName[x][y] = "??";
                break;
        }
    }

    public void toggleFog()
    {
        if (fog)
            fog = false;
        else
            fog = true;
    }

    public void setFertility(int x, int y, double i)
    {
        fertility[x][y] = i;
    }

    public void setMining(int x, int y, double i)
    {
        mining[x][y] = i;
    }

    public void setLumber(int x, int y, double i)
    {
        lumber[x][y] = i;
    }

    public void setBiomeVisible(int x, int y, boolean b)
    {
        biomeVisible[x][y] = b;
    }

    public void setStatsVisible(int x, int y, boolean b)
    {
        statsVisible[x][y] = b;
    }
}
