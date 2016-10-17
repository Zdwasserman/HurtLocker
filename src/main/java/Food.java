import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class Food
{
    String name;
    String type;
    String price;
    String experation;
    Patterns patterns = new Patterns();
    public Food(){

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getExperation() {
        return experation;
    }

    public Food(String name, String type, String price, String experation)
    {
        this.name = name;
        this.type = type;
        this.price = price;
        this.experation = experation;
    }


}
