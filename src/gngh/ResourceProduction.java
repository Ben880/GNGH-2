package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ResourceProduction
{

    private static ResourceProduction instance = null;
    private Calculator calc;
    private ResourceInfo resources;
    private int foodProduction;
    private int lumberProduction;
    private int stoneProduction;
    private int oreProduction;
    private int toolsProduction;
    private int animalsProduction;
    private int horsesProduction;
    private int peopleProduction;
    private int troopsProduction;
    private int medicineProduction;

    private ResourceProduction()
    {

    }

    public static ResourceProduction getInstance()
    {
        if (instance == null)
        {
            instance = new ResourceProduction();
        }
        return instance;
    }

    public void dayChange()
    {
        resources = ResourceInfo.getInstance();
        resources.setFood(resources.getFood() + food());
        resources.setLumber(resources.getLumber() + 50);
        resources.setStone(resources.getStone() + 10);
        resources.setOre(resources.getOre() + 5);
        resources.setPeople(resources.getPeople() + 2);
    }

    public int food()
    {
        int food = 0;
        food = foodProduction - (resources.getPeople() * 3) - (resources.getTroops() * 5) - (resources.getAnimals() * 4) - (resources.getHorses() * 6);
        return food;
    }

    public void setFoodProduction(int foodProduction)
    {
        this.foodProduction = foodProduction;
    }

    public void setLumberProduction(int lumberProduction)
    {
        this.lumberProduction = lumberProduction;
    }

    public void setStoneProduction(int stoneProduction)
    {
        this.stoneProduction = stoneProduction;
    }

    public void setOreProduction(int oreProduction)
    {
        this.oreProduction = oreProduction;
    }

    public void setToolsProduction(int toolsProduction)
    {
        this.toolsProduction = toolsProduction;
    }

    public void setAnimalsProduction(int animalsProduction)
    {
        this.animalsProduction = animalsProduction;
    }

    public void setHorsesProduction(int horsesProduction)
    {
        this.horsesProduction = horsesProduction;
    }

    public void setPeopleProduction(int peopleProduction)
    {
        this.peopleProduction = peopleProduction;
    }

    public void setTroopsProduction(int troopsProduction)
    {
        this.troopsProduction = troopsProduction;
    }

    public void setMedicineProduction(int medicineProduction)
    {
        this.medicineProduction = medicineProduction;
    }

}
