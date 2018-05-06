import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class RuleParser extends XMLParser {

    private Answer answer;
    private RuleRepository ruleRepository;
    private String questionId;

    public RuleParser(String filePath) {
        super(filePath);
        this.answer = new Answer();
        this.ruleRepository = new RuleRepository();
        this.questionId = "";
    }

    public RuleRepository getRuleRepository() {

        Document doc = this.getDocument();
        Element root = doc.getDocumentElement();
        NodeList rulesNodes = root.getChildNodes();
        
        for (int i = 0; i < rulesNodes.getLength(); i++) {
            Node ruleNode = rulesNodes.item(i);
            if (ruleNode instanceof Element) {
                this.createQuestion(ruleNode);
            }
        }
        return this.ruleRepository;
    }

    private void createQuestion(Node ruleNode) {

        Element rule = (Element) ruleNode;
        NodeList questionsList = rule.getChildNodes();
        this.questionId = rule.getAttribute("id");

        for (int j = 0; j < questionsList.getLength(); j++) {

            Node questionNode = questionsList.item(j);
            String questionString = "";

            if (questionNode instanceof Element) {

                if (questionNode.getNodeName().equals("Question")) {
                    Text text = (Text) questionNode.getFirstChild();
                    questionString = text.getData().trim();
                } else if (questionNode.getNodeName().equals("Answer")) {
                    Element elem = (Element) questionNode;
                    String value = elem.getAttribute("value");
                    boolean selectionType = true;
                    this.answer.addValue(new SingleValue(value, selectionType));
                }
                
            }

            Question question = new Question(questionId, questionString, answer);
            this.ruleRepository.addQuestion(question);
        }
        
    }
}