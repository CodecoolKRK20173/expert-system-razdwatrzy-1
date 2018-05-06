import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class RuleRepository {

    private List<Question> rules;

    public RuleRepository(){
        this.rules = new ArrayList<>();
    }

    public void addQuestion(Question question){
        rules.add(question);
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator(rules);
    }

}