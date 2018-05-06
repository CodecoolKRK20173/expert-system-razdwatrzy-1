import java.util.Iterator;
import java.util.List;

public class QuestionIterator implements Iterator<Question> {
    private int index;
    private List<Question> rules;

    QuestionIterator(List<Question> rules) {
        this.rules = rules;

    }

    @Override
    public Question next() {
        return rules.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < rules.size();
    }
}