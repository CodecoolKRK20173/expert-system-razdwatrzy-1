import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {

    private RuleParser ruleParser;
    private FactParser factParser;
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userAnswers;
    private Scanner sc;
    private String userInput;
    private Answer answer;
    private Boolean result;

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
        userAnswers = new HashMap<>();
        sc = new Scanner(System.in);

        while (questions.hasNext()) {
            
            Question question = questions.next();
            System.out.println(question.getQuestion());
            userInput = sc.next();
            result = question.getEvaluatedAnswer(userInput);
            System.out.println(result);
            userAnswers.put(question.getId(), result);
        }

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }

    public String evaluate() {
        return "tak";
    }

}