package research;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
    BenjaminWilcox
    Oct 10, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class Technology
{
/// old file for xml and storing some code

    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static NodeList techList;

    public Technology()
    {

        try
        {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            doc = builder.parse("../research/technology.xml");
            techList = doc.getElementsByTagName("tech");
        } catch (SAXException ex)
        {
            Logger.getLogger(Technology.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Technology.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex)
        {
            Logger.getLogger(Technology.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("Node Search test:");
//        Element test = (Element) getParent("BasicTools");
//        System.out.println(test.getAttribute("name"));
//        test = (Element) getChiled("BasicTools", "time");
//        System.out.println(test.getTextContent());
//        test = (Element) getXChiled("Iron", 1, "depends");
//        System.out.println(test.getTextContent());

    }

    public String getParentName(int i)
    {

        if (i <= techList.getLength())
        {
            Node tech = techList.item(i);
            Element techElement = (Element) tech;
            return techElement.getAttribute("name");
        }
        return null;
    }

    public boolean getAquiered(String parentName)
    {
        //Node temp = getParent(parentName).getChildNodes().item(1);
        return Boolean.valueOf(getChiledText(parentName, "aquired"));
    }

    public boolean getAquiered(int i)
    {
        if (i <= techList.getLength())
        {
            //Element temp = (Element) techList.item(i).getChildNodes().item(1);
            //return Boolean.valueOf(temp.getTextContent());
            return Boolean.valueOf(getChiledText(getParentName(i), "aquired"));
        }
        return false;
    }

    public String getDepend1(int i)
    {
        Node temp = techList.item(i).getChildNodes().item(5);
        //System.out.println("Passing " + temp.getTextContent());
        //return temp.getTextContent();
        return getChiledText(getParentName(i), "dependant1");
    }

    public String getDepend2(int i)
    {
        Node temp = techList.item(i).getChildNodes().item(7);
        //System.out.println("Passing " + temp.getTextContent());
        //return temp.getTextContent();
        return getChiledText(getParentName(i), "dependant2");
    }

    public boolean getDependAquiered(int i)
    {
        Element tem = (Element) techList.item(i);
        if (i <= techList.getLength())
        {
            if (i < 1)
                return true;
            //System.out.println("Testing " + tem.getAttribute("name"));
            if (getAquiered(getDepend1(i)) && getAquiered(getDepend2(i)))
            {
                return true;
            }
        }
        return false;
    }

    //being used
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
            //System.out.println("Checked " + type.toString() + " for " + parentName.toString());
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
    // old stuff
    //node usage for inernal stuff
//    public String getParentString(String parentName)
//    {
//        String type;
//        Node tech;
//        for (int i = 0; i < techList.getLength(); i++)
//        {
//            tech = techList.item(i);
//            Element techElement = (Element) tech;
//            return techElement.getAttribute("name");
//        }
//        System.out.println("Found No String results for " + parentName);
//        return null;
//    }
//
//    public Node getParentAt(int i)
//    {
//        String type;
//        Node tech;
//        if (i <= techList.getLength())
//        {
//            tech = techList.item(i);
//            Element techElement = (Element) tech;
//            type = techElement.getAttribute("name");
//            return tech;
//        }
//        System.out.println("Found No results for parent at " + i);
//        return null;
//    }
//
//    public Node getChiled(String parentName, String chiledName)
//    {
//        NodeList children = getParent(parentName).getChildNodes();
//        for (int j = 0; j < children.getLength(); j++)
//        {
//            Node chiled = children.item(j);
//            if (chiled.getNodeType() == Node.ELEMENT_NODE)
//            {
//                Element chiledElement = (Element) chiled;
//                if (chiledElement.getTagName() == chiledName)
//                    return chiled;
//            }
//        }
//        return null;
//    }
//
//    public Node getChiledAt(int i, int j)
//    {
//        NodeList children = getParentAt(i).getChildNodes();
//        if (j <= children.getLength())
//        {
//            Node chiled = children.item(j);
//            if (chiled.getNodeType() == Node.ELEMENT_NODE)
//            {
//                Element chiledElement = (Element) chiled;
//                return chiled;
//            }
//        }
//        return null;
//    }
//
//    public Node getXChiled(String parentName, int i, String chiledName)
//    {
//        NodeList children = getParent(parentName).getChildNodes();
//        for (int j = 0; j < children.getLength(); j++)
//        {
//            Node chiled = children.item(j);
//            if (chiled.getNodeType() == Node.ELEMENT_NODE)
//            {
//                Element chiledElement = (Element) chiled;
//                if (chiledElement.getTagName() == chiledName)
//                {
//                    if (i == 0)
//                        return chiled;
//                    i--;
//                }
//            }
//        }
//        return null;
//    }
//
//    public String getTextContent(String parentName, String chiledName)
//    {
//        Element element = (Element) getChiled(parentName, chiledName);
//        if (element != null)
//            return element.getTextContent();
//        return "";
//    }
//
//    public String getTextContent(String parentName, int i, String chiledName)
//    {
//        Element element = (Element) getXChiled(parentName, i, chiledName);
//        if (element != null)
//            return element.getTextContent();
//        return "";
//    }
//

//
//    public int getChildLength(int i)
//    {
//        NodeList children = getParentAt(i).getChildNodes();
//        return children.getLength();
//    }
}
