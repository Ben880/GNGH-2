package research;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class XMLReader
{

    NodeList techList;

    public XMLReader()
    {
        XMLLoader loader = new XMLLoader();
        techList = loader.getList();
    }

    public String getParentName(int i)
    {
        //System.out.println(i);
        if (i <= techList.getLength())
        {
            Node tech = techList.item(i);
            Element techElement = (Element) tech;
            //System.out.println(techElement.getAttribute("name"));
            return techElement.getAttribute("name");
        }
        return null;
    }

    public boolean getAquiered(String parentName)
    {
        return Boolean.valueOf(getChiledText(parentName, "aquired"));
    }

    public boolean getAquiered(int i)
    {
        if (i <= techList.getLength())
        {
            return Boolean.valueOf(getChiledText(getParentName(i), "aquired"));
        }
        return false;
    }

    public String getDepend1(int i)
    {
        return getChiledText(getParentName(i), "dependant1");
    }

    public String getDepend2(int i)
    {
        return getChiledText(getParentName(i), "dependant2");
    }

    public boolean getDependAquiered(int i)
    {
        if (i <= techList.getLength())
        {
            if (i < 1)
                return true;
            if (getAquiered(getDepend1(i)) && getAquiered(getDepend2(i)))
            {
                return true;
            }
        }
        return false;
    }

    public int getTime(int i)
    {
        return Integer.parseInt(getChiledText(getParentName(i), "time"));
    }

    public Double getMultiplier(int i)
    {
        return Double.parseDouble(getChiledText(getParentName(i), "multiplier"));
    }

    public String getStat(int i)
    {
        return getChiledText(getParentName(i), "stat");
    }

    public String getChiledText(String parentName, String chiledName)
    {
        NodeList children = getParent(parentName).getChildNodes();
        for (int j = 0; j < children.getLength(); j++)
        {
            Node chiled = children.item(j);
            if (chiled.getNodeType() == Node.ELEMENT_NODE)
            {
                Element chiledElement = (Element) chiled;
                if (chiledElement.getTagName().equalsIgnoreCase(chiledName))
                    return chiledElement.getTextContent();
            }
        }
        return null;
    }

    public Node getParent(String parentName)
    {
        String type;
        Node tech;
        for (int i = 0; i < techList.getLength(); i++)
        {
            tech = techList.item(i);
            Element techElement = (Element) tech;
            type = techElement.getAttribute("name");
            if (type.equals(parentName))
                return tech;
        }
        System.out.println("Found No Node results for " + parentName);
        return null;
    }

    public int getParentLength()
    {
        return techList.getLength();
    }

}
