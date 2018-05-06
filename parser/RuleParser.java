package parser;

import java.util.ArrayList;
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

        Document doc = this.getDocument();
        Element rootRules = doc.getDocumentElement();
        NodeList rulesNodes = rootRules.getChildNodes();

        RuleRepository ruleRepository = new RuleRepository();

        Answer answer = new Answer();
        
        for (int i = 0; i < rulesNodes.getLength(); i++) {

            Node ruleNode = rulesNodes.item(i);
            if (ruleNode instanceof Element) {
                
                Element rule = (Element) ruleNode;
                NodeList questions = rule.getChildNodes();
                String id = rule.getAttribute("id");

                for (int j = 0; j < questions.getLength(); j++) {

                    Node question = questions.item(j);

                    if (question instanceof Element) {

                        Text text = (Text) question.getFirstChild();
                        String questionString = text.getData().trim();
                        ruleRepository.addQuestion(question);

                        Question question = new Question(id, questionString, answer);
                        ruleRepository.addQuestion(question);
                    }

                }

            }
        }

        return ruleRepository;
    

    }
}