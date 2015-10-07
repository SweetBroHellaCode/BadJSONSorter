import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class Item {
    public String   name;
    public Float    price;
    public String   type;
    public Date     expiration;

    private String rawData;

    public Item(String inputData){
        this.rawData = inputData;
        parseRawData();
    }

    private void parseRawData(){
        String[] rawDataArray = rawData.split("[;%!@^]");
        for(String element: rawDataArray){
            Pattern pattern = Pattern.compile("name:\\w+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(element);
            if (matcher.find()){
                String[] keyValue = element.split(":");
                this.name = keyValue[1];
            }
        }

    }
}
