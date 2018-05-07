import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {

    private FactRepository factRepo;

    FactParser(String filePath) {
        super(filePath);
    }

    public FactRepository getFactRepository() {

        FactRepository factRepository = new FactRepository();
        NodeList nodeList = this.getDocument().getElementsByTagName("Fact");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element elem = (Element) nodeList.item(i);
                if (elem instanceof Element) {
                    Fact fact = createFact(elem);
                    factRepository.addFact(fact);
                }
        }

        return factRepository;
    }

    private Fact createFact(Element elem) {

        String id = elem.getAttribute("id");
        String description = getDescription(elem);
        Fact fact = new Fact(id, description);
        
        this.getFactAttributes(elem, fact);
        
        return fact;
    } 
   
    private String getDescription(Element elem) {

        String description = elem.getAttribute("Description");
        
        return description;
    }

    private void getFactAttributes(Element elem, Fact fact) {

        NodeList evals = elem.getElementsByTagName("Eval");
        for (int i = 0; i < evals.getLength(); i++) {
            Node node = evals.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String valueString = element.getTextContent();
                    boolean value;
                    if (valueString.equals("true")) {
                        value = true;
                    } else value = false;
                    fact.setFactValueByID(id, value);
                }
        }
    }
}