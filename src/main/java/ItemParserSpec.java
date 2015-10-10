import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jguevara on 10/9/15.
 */
public class ItemParserSpec {

    ItemParser itemParserTest;

    @Before

    public void resourcesNeededToTest() {
        itemParserTest = new ItemParser();
    }

    @Test

    public void givenInputShouldReturnParsedStringArray() {
        assertEquals("Should return a String Array of length 28", 28, itemParserTest.parseInput().length);
    }
}
