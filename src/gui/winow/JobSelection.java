package gui.winow;

/*
    BenjaminWilcox
    Jun 14, 2017
    GNGH_2
 */
public class JobSelection
{

    String name;
    int number;

    public JobReturn jobSelection()
    {

        return new JobReturn(name, number);
    }

}
