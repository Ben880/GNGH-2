package player.resources;

/*
    BenjaminWilcox
    Aug 6, 2017
    GNGH2
 */
public class NoSuchResourceException extends Exception
{

    public NoSuchResourceException(String s)
    {
        System.out.println("Resource " + s + " does not exist");
    }

}
