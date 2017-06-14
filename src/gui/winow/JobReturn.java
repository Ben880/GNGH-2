package gui.winow;

/*
    BenjaminWilcox
    Jun 14, 2017
    GNGH_2
 */
public class JobReturn
{

    private String name;
    private int number;

    public JobReturn(String s, int i)
    {
        name = s;
        number = i;
    }

    public String getJob()
    {
        return name;
    }

    public int getAmount()
    {
        return number;
    }

}
