import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class RuleParser extends XMLParser {

    public RuleParser(String filePath) {
        super(filePath);
    }

    public RuleRepository getRuleRepository() {
        RuleRepository ruleRepository = new RuleRepository();
        NodeList nodeList = this.getDocument().getElementsByTagName("Rule");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element rule = (Element) nodeList.item(i);
            if (rule instanceof Element) {
                Question question = createQuestion(rule);
                ruleRepository.addQuestion(question);
            }
        }
        return ruleRepository;
    }

    private Question createQuestion(Element rule) {
        String id = rule.getAttribute("id");
        String questionString = rule.getElementsByTagName("Question").item(0).getTextContent();
        Answer answer = createAnswer((Element) rule.getElementsByTagName("Answer").item(0));
        return new Question(id, questionString, answer);
    }

    private Answer createAnswer(Element answer) {
        NodeList selectionList = answer.getElementsByTagName("Selection");
        Answer newAnswer = new Answer();
        for (int i = 0; i < selectionList.getLength(); i++) {
            newAnswer.addValue(getValueObject(selectionList.item(i)));
        }
        return newAnswer;
    }

    private Value getValueObject(Node selection) {
        NodeList childList = selection.getChildNodes();
        for (int i = 0; i < childList.getLength(); i++) {
            if (childList.item(i) instanceof Element) {
                return getValueInstance((Element) childList.item(i), (Element) selection);
            }
        }
        return null;
    }

    private Value getValueInstance(Element child, Element parent) {
        String name = "value";
        if (child.getTagName().equals("SingleValue")) {
            return new SingleValue(child.getAttribute(name), parent.getAttribute(name).equals("true"));
        } else return null;
    }

}