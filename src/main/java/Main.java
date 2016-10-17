import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        Patterns patterns = new Patterns();
        Counter counter = new Counter();
        Matcher matcher;
        String output = (new Main()).readRawDataToString();
        matcher = patterns.apples(output);
        int numOfApples = counter.patternCounter(matcher);
        matcher = patterns.bread(output);
        int numOfBread = counter.patternCounter(matcher);
        matcher = patterns.cookies(output);
        int numOfCookies = counter.patternCounter(matcher);
        matcher = patterns.milk(output);
        int numOfMilk = counter.patternCounter(matcher);
        System.out.println("Milk: " +numOfMilk);
        System.out.println("Bread: " + numOfBread);
        System.out.println("Cookies: " +numOfCookies);
        System.out.println("Apples: " + numOfApples);



    }

}
