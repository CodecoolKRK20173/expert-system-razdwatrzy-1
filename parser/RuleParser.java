package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    public RuleParser() {
        super("parser/Rules.xml");
    }

    public RuleRepository getRuleRepository() {

        Document doc = this.getDocument();
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        RuleRepository ruleRepository = new RuleRepository();

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node child = nodeList.item(i);
            if (child instanceof Element) {
                
                Element childElement = (Element) child;
                NodeList childs = childElement.getChildNodes();

                for (int j = 0; j < childs.getLength(); j++) {

                    Node test = childs.item(j);

                    if (test instanceof Element) {

                        System.out.println(test.getNodeName());

                    }

                }

            }
        }

        return null;
    

    }
}