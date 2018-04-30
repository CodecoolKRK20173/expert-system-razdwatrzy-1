import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public abstract class XMLParser {
    
    public void loadXmlDocument(String xmlPath) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File(xmlPath);
        Document doc = builder.parse(xmlPath);

     }
}