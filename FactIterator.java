import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator<Fact> {

    private int index;
    private List<Fact> facts;

    public FactIterator(List<Fact> facts) {
        this.facts = facts;
    }

    public boolean hasNext() {
        return index < facts.size();
    }

    public Fact next() {
        return facts.get(index++);
    }

}