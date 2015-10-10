import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by emaron on 10/10/15.
 */
public class ItemSpec {

    Item itemTest;

    String[] inputTest = new String[3];

    @Before

    public void resourcesNeededToTest() {
        inputTest[0] = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        inputTest[1] = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        inputTest[2] = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016";
        itemTest = new Item(inputTest);
    }

    @Test

    public void whenInstantiatedShouldFillNameStringArray() {
        assertEquals("Should return a length of 3", 3, itemTest.getNameHolder().size());

    }

    @Test

    public void whenInstantiatedShouldFillPriceStringArray() {
        assertEquals("Should return a length of 3", 3, itemTest.getPriceHolder().size());

    }

    @Test

    public void whenInstantiatedShouldEvaluateAmountOfErrors() {
        assertEquals("Should return 0", 0, itemTest.getErrorCount());
    }
    

}
