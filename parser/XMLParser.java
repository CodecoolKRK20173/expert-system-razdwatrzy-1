import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class XMLParser {
    
    public void loadXmlDocument(String xmlPath) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        File file = new File(xmlPath);

        try {
            builder = factory.newDocumentBuilder();
        }   catch(ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Document doc = builder.parse(file);
        }   catch(SAXException e) {
            e.printStackTrace();
        }   catch(IOException e) {
            e.printStackTrace();
        }

     }
}