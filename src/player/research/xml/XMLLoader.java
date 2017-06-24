package player.research.xml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class XMLLoader
{

    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static NodeList techList;

    public XMLLoader()
    {

        try
        {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            doc = builder.parse("C:\\Users\\bmwla\\Desktop\\Ben\\Java\\NetBeans\\GNGH2\\src\\player\\research\\xml\\technology.xml");
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
    }

    public NodeList getList()
    {
        return techList;
    }
}
