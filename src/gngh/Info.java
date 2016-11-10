package gngh;

/*
    BenjaminWilcox
    Oct 16, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class Info
{

    /*
        files to import
        VisibleInfo
        OwnershipInfo
        EnemyInfo
     */
    private static Info instance = null;
    VisibleInfo visible;
    OwnershipInfo owned;
    EnemyInfo enemy;
    ResourceInfo resources;

    private Info()
    {
        visible = new VisibleInfo();
        owned = new OwnershipInfo();
        enemy = new EnemyInfo();
        resources = new ResourceInfo();
    }

    public static Info getInstance()
    {
        if (instance == null)
            instance = new Info();
        return instance;
    }

    public VisibleInfo visible()
    {
        return visible;
    }

    public OwnershipInfo owned()
    {
        return owned;
    }

    public EnemyInfo enemy()
    {
        return enemy;
    }

    public ResourceInfo resources()
    {
        return resources;
    }
}
