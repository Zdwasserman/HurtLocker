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

    public static void main(String[] args) throws Exception{


        Matcher matcher;
        String output = (new Main()).readRawDataToString();

        //String[] data = food.splitRaw(output);
        //ArrayList<String[]> foodlist= food.splitData(data);
        //food.createFood(foodlist);

    }

}
