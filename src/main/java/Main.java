import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        String output = (new Main()).readRawDataToString();
        String[] data = parser.splitRaw(output);
        ArrayList<String[]> foodlist = parser.splitData(data);
        parser.createFood(foodlist);
        parser.fixNames(parser.foods);
        parser.getPrices(parser.foods);
        parser.combineFoodList(parser.foods);
        parser.displayData();
    }


    }


