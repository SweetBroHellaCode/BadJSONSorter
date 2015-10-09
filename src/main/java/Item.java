import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jguevara on 10/9/15.
 */
public class Item {
    public String name;
    public double price;
    public String type;
    public Date expiration;

    /**
     *
     * @param regex
     * @param rawItem
     * @return
     */
    private static Matcher generateMatcher(String regex, String rawItem){
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        return pattern.matcher(rawItem);
    }


    public Item(String input){
        String[] itemArray = input.split("[;^*%@!]");

        Matcher name = generateMatcher("name:([\\w\\d]+)", itemArray[0]);
        name.find();
        System.out.println(name.group(1));
    }
}
