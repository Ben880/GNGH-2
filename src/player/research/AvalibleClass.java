package player.research;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class AvalibleClass
{

    private static TechList tech = new TechList();

    public AvalibleClass()
    {

    }

    public void summary()
    {
        TechBuilder build = new TechBuilder();
        build.build();
        System.out.println("From Class Tree");
        getCompleetList();
        getAvalibleList();
        getLocked();
    }

    public void getCompleetList()
    {
        System.out.println("Compleet:");
        for (int i = 0; i < tech.length(); i++)
        {
            if (tech.getTech(i).isAquired())
                System.out.println(tech.getTech(i).getName());
        }
    }

    public void getAvalibleList()
    {
        System.out.println("Avalible:");
        for (int i = 0; i < tech.length(); i++)
        {
            if (tech.getTech(i).getDependant1().isAquired() && tech.getTech(i).getDependant2().isAquired() && !tech.getTech(i).isAquired())
                System.out.println(tech.getTech(i).getName());
        }
    }

    public void getLocked()
    {
        System.out.println("Locked:");
        for (int i = 0; i < tech.length(); i++)
        {
            if (!tech.getTech(i).getDependant1().isAquired() && !tech.getTech(i).getDependant2().isAquired())
                System.out.println(tech.getTech(i).getName());
        }
    }

}
