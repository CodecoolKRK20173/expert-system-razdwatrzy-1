import java.util.List;

public abstract class Value {

    protected List<String> params;
    protected boolean selectionType;

    public List<String> getInputPattern() {
        return this.params;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
    
}