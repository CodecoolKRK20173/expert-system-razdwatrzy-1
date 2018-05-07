import java.util.Iterator;
import java.util.Scanner;

public class ESProvider {

    private RuleParser ruleParser;
    private FactParser factParser;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    public ESProvider() {
        this("Rules.xml", "Facts.xml");
    }

    private ESProvider(String rulesFilePath, String factsFilePath) {
        this.ruleParser = new RuleParser(rulesFilePath);
        this.factParser = new FactParser(factsFilePath);
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
    }

    public void collectAnswers() {

        Iterator<Question> questions = ruleRepository.getIterator();

        while (questions.hasNext()) {
            
            Question question = questions.next();
            System.out.println(question.getQuestion());

            Scanner sc = new Scanner(System.in);
            String ui = sc.next();

        }

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }

    public String evaluate() {
        return "tak";
    }

}