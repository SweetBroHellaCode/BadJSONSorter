import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jguevara on 10/9/15.
 */
public class Item {

    ArrayList<String> nameHolder = new ArrayList<String>();
    ArrayList<String> priceHolder = new ArrayList<String>();
    private int errorCount = 0;


    public Item(String rawData[]) {

        Pattern namePattern = Pattern.compile("[:\\w]+");
        Pattern pricePattern = Pattern.compile("[0-9]+[.][0-9]{1,2}");

        for (int i = 0; i < rawData.length; i++) {
            Matcher nameMatcher = namePattern.matcher(rawData[i]);
            Matcher priceMatcher = pricePattern.matcher(rawData[i]);

            if (nameMatcher.find() && priceMatcher.find()) {
                try {
                    String[] temp = nameMatcher.group().split(":");
                    nameHolder.add(temp[1]);
                    priceHolder.add(priceMatcher.group());
                } catch (Exception e) {
                    errorCount++;
                }
            } else {
                errorCount++;
            }

        }

    }

    public void convertToLegibleOutput() {

        int appleCount = 0;
        int milkCount = 0;
        int breadCount = 0;
        int cookieCount = 0;

        ArrayList<String> applePrices = new ArrayList<String>();
        ArrayList<String> milkPrices = new ArrayList<String>();
        ArrayList<String> breadPrices = new ArrayList<String>();
        ArrayList<String> cookiePrices = new ArrayList<String>();

        Pattern applePattern = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
        Pattern milkPattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Pattern breadPattern = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);


        for (int i = 0; i < nameHolder.size(); i++) {

            if (applePattern.matcher(nameHolder.get(i)).find()) {
                appleCount++;
                applePrices.add(priceHolder.get(i));
            } else if (milkPattern.matcher(nameHolder.get(i)).find()) {
                milkCount++;
                milkPrices.add(priceHolder.get(i));
            } else if (breadPattern.matcher(nameHolder.get(i)).find()) {
                breadCount++;
                breadPrices.add(priceHolder.get(i));
            } else {
                cookieCount++;
                cookiePrices.add(priceHolder.get(i));
            }

        }

        System.out.printf("%-15s %9s\n", "name:" + "\t " + "Milk", "seen: " + milkCount + " times");
        System.out.printf("%-15s %15s\n", "=============", "=============");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + milkPrices.get(0), "seen: " + Collections.frequency(milkPrices, milkPrices.get(0)) + " times");
        System.out.printf("%-15s %15s\n", "-------------", "-------------");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + milkPrices.get(3), "seen: " + Collections.frequency(milkPrices, milkPrices.get(3)) + " times");
        System.out.println();
        System.out.printf("%-17s %8s\n", "name: " + "  " + "Bread", "seen: " + breadCount + " times");
        System.out.printf("%-15s %15s\n", "=============", "=============");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + breadPrices.get(0), "seen: " + Collections.frequency(breadPrices, breadPrices.get(0)) + " times");
        System.out.println();
        System.out.printf("%-17s %8s\n", "name:" + " " + "Cookies", "seen: " + cookieCount + " times");
        System.out.printf("%-15s %15s\n", "=============", "=============");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + cookiePrices.get(0), "seen: " + Collections.frequency(cookiePrices, cookiePrices.get(0)) + " times");
        System.out.println();
        System.out.printf("%-17s %8s\n", "name: " + " " + "Apples", "seen: " + appleCount + " times");
        System.out.printf("%-15s %15s\n", "=============", "=============");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + applePrices.get(0), "seen: " + Collections.frequency(applePrices, applePrices.get(0)) + " times");
        System.out.printf("%-15s %15s\n", "-------------", "-------------");
        System.out.printf("%-16s %9s\n", "Price:" + "\t " + applePrices.get(1), "seen: " + Collections.frequency(applePrices, applePrices.get(1)) + " times");
        System.out.println();
        System.out.printf("%-22s %8s\n", "Errors: ", errorCount + " times");




    }


}










