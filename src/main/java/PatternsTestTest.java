import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class PatternsTestTest
{


    @Test
    public void nameTest()
    {
        Counter counter = new Counter();
        Patterns patterns = new Patterns();
        Matcher matcher = patterns.name("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");
        int actual = counter.patternCounter(matcher);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void milkTest()
    {
        Counter counter = new Counter();
        Patterns patterns = new Patterns();
        Matcher matcher = patterns.milk("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK");
        int actual = counter.patternCounter(matcher);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void ApplesTest()
    {
        Counter counter = new Counter();
        Patterns patterns = new Patterns();
        Matcher matcher = patterns.apples("applesAPPLESApPlES");
        int actual = counter.patternCounter(matcher);
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void breadTest()
    {
        Counter counter = new Counter();
        Patterns patterns = new Patterns();
        Matcher matcher = patterns.bread("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016;Brwsd");
        int actual = counter.patternCounter(matcher);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void cookieTest()
    {
        Counter counter = new Counter();
        Patterns patterns = new Patterns();
        Matcher matcher = patterns.cookies("Co0kiescooKies");
        int actual = counter.patternCounter(matcher);
        int expected = 2;
        assertEquals(expected, actual);
    }

}