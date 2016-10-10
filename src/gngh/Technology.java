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
