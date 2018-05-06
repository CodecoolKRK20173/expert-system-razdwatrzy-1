import java.util.HashMap;
import java.util.Map;

public class RuleRepository {

    private Map<String, String> rules;

    public RuleRepository(){
        this.rules = new HashMap<>();
    }

    public void addQuestion(Question question){
        rules.put(question.getQuestion(), question.getId());
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator();
    }

}