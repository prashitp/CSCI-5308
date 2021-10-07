import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<String> validate(String... values) {
        List<String> errorArray = new ArrayList<String>();
        for(String value: values){
            String[] forValue = value.split("\\.");
            if(forValue[1].length() > 2) {
                errorArray.add("Decimal Exceeded for " + value);
            }
        }
        return errorArray;
    }
}
