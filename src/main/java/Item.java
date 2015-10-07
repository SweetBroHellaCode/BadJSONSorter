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
        String[] rawDataArray = rawData.split("[;%!@^*]");
        Pattern namePattern = Pattern.compile("name:\\w+", Pattern.CASE_INSENSITIVE);
        Pattern pricePattern = Pattern.compile("price:\\w+", Pattern.CASE_INSENSITIVE);
        Pattern typePattern = Pattern.compile("type:\\w+", Pattern.CASE_INSENSITIVE);
        Pattern expirationPattern = Pattern.compile("expiration:\\w+", Pattern.CASE_INSENSITIVE);
        for(String element: rawDataArray){
            try {
                if (namePattern.matcher(element).find()) {
                    this.name = element.split(":")[1];
                } else if (pricePattern.matcher(element).find()) {
                    this.price = Float.valueOf(element.split(":")[1]);
                } else if (typePattern.matcher(element).find()){
                    this.type = element.split(":")[1];
                }
            } catch (Exception e){
                //throw new
            }
        }

    }
}
