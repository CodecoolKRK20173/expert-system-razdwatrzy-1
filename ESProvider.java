import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {

    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userAnswers;

    public ESProvider() {
        this("Rules.xml", "Facts.xml");
    }

    private ESProvider(String rulesFilePath, String factsFilePath) {

        this.ruleRepository = new RuleParser(rulesFilePath).getRuleRepository();
        this.factRepository = new FactParser(factsFilePath).getFactRepository();
    }

    public void collectAnswers() {

        Iterator<Question> questions = ruleRepository.getIterator();
        userAnswers = new HashMap<>();

        while (questions.hasNext()) {

            Question question = questions.next();
            System.out.println(question.getQuestion());
            Boolean result = this.validateUserInput(question);
            userAnswers.put(question.getId(), result);
        }
        System.out.println(evaluate());
    }

    public String evaluate() {

        Iterator<Fact> facts = factRepository.getIterator();

        while (facts.hasNext()) {
            Fact fact = facts.next();
            if (fact.getidMap().equals(userAnswers)) {
                return fact.getDescription();
            }

        }
        return "There is no such option!";
    }

    private Boolean validateUserInput(Question question) {

        boolean isWrongInput = true;
        Scanner sc;
        String userInput;
        Boolean result;
        sc = new Scanner(System.in);

        while (isWrongInput) {
            userInput = sc.next();
            try {
                result = question.getEvaluatedAnswer(userInput);
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Wrong answer!");
                System.out.println(question.getQuestion());
            }
        }
        return null;
    }
}