import java.util.ArrayList;
import java.util.List;

public class FactRepository {

    private List<Fact> facts;
    
    public FactRepository() {
        this.factRepo = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator(facts);
    }

}