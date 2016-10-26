package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class OwnershipInfo
{

    private boolean[][] owned = new boolean[20][20];
    private int[][] structure = new int[20][20];

    public OwnershipInfo()
    {

    }

    public void setOwned(int x, int y, boolean b)
    {
        owned[x][y] = b;
    }

    public void setStructure(int x, int y, int i)
    {
        structure[x][y] = i;
    }

    public boolean getOwned(int x, int y)
    {
        return owned[x][y];
    }

    public int getStructure(int x, int y)
    {
        return structure[x][y];
    }
}
