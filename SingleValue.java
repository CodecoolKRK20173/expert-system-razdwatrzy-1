import java.util.List;

public class SingleValue extends Value {

    private String param;

    public SingleValue(String param, boolean selectionType) {
        this.param = param;
        params.add(param);
        super.params = params;
    }
    
}