import java.util.regex.Matcher;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class Counter {
    public int patternCounter(Matcher matcher)
    {
        int count = 0;
        while(matcher.find())
        {
            count++;
        }
        return count;
    }
}
