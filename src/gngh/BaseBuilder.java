package gngh;

/*
    BenjaminWilcox
    Oct 10, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class BaseBuilder
{

    private static BaseBuilder instance = null;

    private int space = 50;
    private int stockpile = 0;
    private int shelter = 0;
    private int farm = 0;
    private int woodWalls = 0;
    private int stoneWalls = 0;
    //structures
    private int housing = 0;
    private int shed = 0;
    private int barn = 0;
    private int stabels = 0;
    private int smith = 0;

    private BaseBuilder()
    {

    }

    public static BaseBuilder getInstance()
    {
        if (instance == null)
        {
            instance = new BaseBuilder();
        }
        return instance;
    }

    //getters and setters
    public int getSpace()
    {
        return space;
    }

    public void setSpace(int space)
    {
        this.space = space;
    }

    public int getStockpile()
    {
        return stockpile;
    }

    public void setStockpile(int stockpile)
    {
        this.stockpile = stockpile;
    }

    public int getShelter()
    {
        return shelter;
    }

    public void setShelter(int shelter)
    {
        this.shelter = shelter;
    }

    public int getFarm()
    {
        return farm;
    }

    public void setFarm(int farm)
    {
        this.farm = farm;
    }

    public int getWoodWalls()
    {
        return woodWalls;
    }

    public void setWoodWalls(int woodWalls)
    {
        this.woodWalls = woodWalls;
    }

    public int getStoneWalls()
    {
        return stoneWalls;
    }

    public void setStoneWalls(int stoneWalls)
    {
        this.stoneWalls = stoneWalls;
    }

    public int getHousing()
    {
        return housing;
    }

    public void setHousing(int housing)
    {
        this.housing = housing;
    }

    public int getShed()
    {
        return shed;
    }

    public void setShed(int shed)
    {
        this.shed = shed;
    }

    public int getBarn()
    {
        return barn;
    }

    public void setBarn(int barn)
    {
        this.barn = barn;
    }

    public int getStabels()
    {
        return stabels;
    }

    public void setStabels(int stabels)
    {
        this.stabels = stabels;
    }

    public int getSmith()
    {
        return smith;
    }

    public void setSmith(int smith)
    {
        this.smith = smith;
    }

}
