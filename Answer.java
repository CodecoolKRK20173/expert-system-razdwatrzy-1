import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {

    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {

        for (Value value : values) {
            for (String option : value.getInputPattern()) {
                return option.equals(input);
            }
        }
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }
}