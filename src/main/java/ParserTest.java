import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class ParserTest {

    @Test
    public void splitRawTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##");
        int actual = splitraw.length;
        int expected = 28;
        assertEquals(expected, actual);
    }
    @Test
    public void splitData()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##");
        ArrayList<String[]> foodList = parser.splitData(splitraw);
        int actual = foodList.get(0).length;
        int expected = 8;
        assertEquals(expected, actual);
    }
    @Test
    public void createFood()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        String actual = parser.foods.get(0).getName();
        String expected = "Milk";
        assertEquals(expected, actual);
    }
    @Test
    public void fixNamesMilkTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:mIlK;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        parser.fixNames(parser.foods);
        String actual = parser.foods.get(0).getName();
        String expected = "Milk";
        assertEquals(expected, actual);

    }
    @Test
    public void fixNamesApplesTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:ApPlEs;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        parser.fixNames(parser.foods);
        String actual = parser.foods.get(0).getName();
        String expected = "Apples";
        assertEquals(expected, actual);

    }
    @Test
    public void fixNamesCookiesTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:C00kIeS;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        parser.fixNames(parser.foods);
        String actual = parser.foods.get(0).getName();
        String expected = "Cookies";
        assertEquals(expected, actual);

    }
    @Test
    public void fixNamesBreadTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:BrEaD;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        parser.fixNames(parser.foods);
        String actual = parser.foods.get(0).getName();
        String expected = "Bread";
        assertEquals(expected, actual);

    }
    @Test
    public void getPricesTest()
    {
        Parser parser = new Parser();
        String[] splitraw = parser.splitRaw("naMe:BrEaD;price:3.23;type:Food;expiration:1/25/2016##");
        ArrayList<String[]> foodlist = parser.splitData(splitraw);
        parser.createFood(foodlist);
        parser.getPrices(parser.foods);
        String actual = parser.listOfPrices.get(0).get(0);
        String expected = "3.23";
        assertEquals(expected, actual);

    }
    @Test
    public void combineFoodListTest()
    {
        Parser parser = new Parser();
        Food food = new Food("Bread", "Food", "3.23", "10/18/2015");
        parser.foods.add(food);
        parser.combineFoodList(parser.foods);
        String actual = parser.allFood.toString();
        String expected = "{Bread=1}";
        assertEquals(expected, actual);
    }




}