package research.xml;

import research.xml.XMLReader;

/*
    BenjaminWilcox
    Jan 21, 2017
    GNGH_2
 */
public class AvalibleXML
{

    //test class for xml reading
    XMLReader read = new XMLReader();

    public AvalibleXML()
    {

    }

    public void summary()
    {

        getCompleetList();
        getAvalibleList();
        getLocked();
    }

    public void getAvalibleList()
    {
        System.out.println("Avalible:");
        for (int i = 0; i < read.getParentLength(); i++)
        {
            if (read.getDependAquiered(i) && !read.getAquiered(i))
            {
                System.out.println(read.getParentName(i));
            }

        }
    }

    public void getCompleetList()
    {
        System.out.println("Compleet:");
        for (int i = 0; i < read.getParentLength(); i++)
        {
            if (read.getAquiered(i))
            {

                System.out.println(read.getParentName(i));
            }
        }
    }

    public void getLocked()
    {
        System.out.println("Locked:");
        for (int i = 0; i < read.getParentLength(); i++)
        {
            if (!read.getDependAquiered(i) && !read.getAquiered(i))
            {
                System.out.println(read.getParentName(i));
            }

        }
    }

}
