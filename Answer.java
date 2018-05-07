import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {

    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) throws InputMismatchException {

        if (input.equals("yes") || input.equals("no")) {
            for (Value value : values) {
                for (String option : value.getInputPattern()) {
                    return option.equals(input);
                }
            }
        } else
            throw new InputMismatchException();
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }
}