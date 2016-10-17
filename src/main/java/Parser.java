import java.util.ArrayList;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class Parser {
    Food foodObject = new Food();
    ArrayList<Food> foods = new ArrayList();

    public String[] splitRaw(String str)
    {
        String[] data = str.split("##");
        return data;
    }

    public ArrayList<String[]> splitData(String[] data)
    {
        ArrayList foodlist = new ArrayList();
        for(String str: data)
        {
            String[] sliced2 = str.split(";|:|,|@|^|%");
            foodlist.add(sliced2);
        }
        return foodlist;
    }
    public void createFood(ArrayList<String[]> foodlist)
    {

        for(String[] foodData : foodlist)
        {
            Food food = new Food();
            food.name = foodData[1];
            food.price = foodData[3];
            food.type = foodData[5];
            food.experation = foodData[7];
            foods.add(food);
        }

    }
    public void fixNames(ArrayList<Food> foods)
    {
        for(Food food : foods)
        {
            if(food.getName().matches("(?i)(m[a-z][a-z]k)"))
            {
                food.name = "Milk";
            }
            if(food.getName().matches("(?i)(ap[a-z][a-z][a-z]s)"))
            {
                food.name = "Apples";
            }
            if(food.getName().matches("(?i)(c[a-z0-9][a-z0-9]kies)"))
            {
                food.name = "Cookies";
            }
            if(food.getName().matches("(?i)(b[a-z][a-z][a-z]d)"))
            {
                food.name = "Bread";
            }


        }
    }

}
