import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import value.*;

public class Answer {

    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {

        for (Value value : values) {
            for (String option : value.getInputPattern()) {
                if (option.equals(input)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }
}