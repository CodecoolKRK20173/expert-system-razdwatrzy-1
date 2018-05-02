import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Fact {

    private String id;
    private String description;
    private boolean value;
    private Map<String, Boolean> idMap;

    public Fact (String id, String description){
        this.id = id;
        this.description = description;
        this.idMap = new TreeMap<>();
    }

    public String getFactID() {
        return this.id;
    }

    public void setFactValueByID (String id, boolean value) {
        idMap.put(id, value);
    }

    public Set<String> getidSet() {
        return this.idMap.keySet();
    }

    public boolean getValueByID(String id) {
        return idMap.get(id);
    }

    public String getDescription() {
        return this.description;
    }


}