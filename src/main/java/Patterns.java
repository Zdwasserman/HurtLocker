import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class Patterns {


    public Matcher name(String str)
    {
        Pattern pattern = Pattern.compile("(?i)(n[a-z][a-z]e:)");
        Matcher matcher = pattern.matcher(str);

        return matcher;
    }
    public Matcher milk(String str)
    {
        Pattern pattern = Pattern.compile("(?i)(m[a-z][a-z]k)");
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
    public Matcher apples(String str)
    {
        Pattern pattern = Pattern.compile("(?i)(ap[a-z][a-z][a-z]s)");
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
    public Matcher cookies(String str)
    {
        Pattern pattern = Pattern.compile("(?i)(c[a-z0-9][a-z0-9]kies)");
        Matcher matcher = pattern.matcher(str);
        return matcher;

    }
    public Matcher bread(String str)
    {
        Pattern pattern = Pattern.compile("(?i)(b[a-z][a-z][a-z]d)");
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
    public Matcher newObject(String str)
    {
        Pattern pattern = Pattern.compile("##");
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }






}
