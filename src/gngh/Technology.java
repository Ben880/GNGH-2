package gngh;

/*
    BenjaminWilcox
    Oct 10, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
class Technology
{

    private static Technology instance = null;
    //numbered technologies
    int attack = 5;
    //primitive technologies
    boolean resourcemanagement = false;
    boolean fire = false;
    boolean choppig = false;
    boolean farming = false;
    boolean fishing = false;
    boolean stonecutting = false;
    boolean organizedtroops = false;
    boolean primitveweapons = false;
    boolean shelter = false;
    //stone age
    boolean stoneage = false;
    boolean walls = false;
    boolean structures = false;
    boolean woodworking = false;
    boolean mining = false;

    boolean stoneworks = false;
    //bronze age
    boolean bornazeage = false;
    boolean alloys = false;

    private Technology()
    {

    }

    private static Technology getInstance()
    {
        if (instance == null)
        {
            instance = new Technology();
        }
        return instance;
    }
}
