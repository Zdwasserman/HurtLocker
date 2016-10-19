import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by zacharywasserman on 10/17/16.
 */
public class Parser {
    ArrayList<Food> foods = new ArrayList();
    ArrayList<ArrayList<String>> listOfPrices = new ArrayList();
    HashMap<String, Integer> milkPrices = new LinkedHashMap<String, Integer>();
    HashMap<String, Integer> breadPrices = new HashMap<String, Integer>();
    HashMap<String, Integer> cookiePrices = new HashMap<String, Integer>();
    HashMap<String, Integer> applePrices = new HashMap<String, Integer>();
    HashMap<String, Integer> allFood = new HashMap<String, Integer>();
    int errors = 0;
    int counter = 0;

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
            String[] sliced2 = str.split(";|:|,|@|^|%|!|/*/");
            foodlist.add(sliced2);
        }
        return foodlist;
    }
    public void createFood(ArrayList<String[]> foodlist)
    {

            for (String[] foodData : foodlist) {
                    Food food = new Food();
                    food.name = foodData[1];
                    food.price = foodData[3];
                    food.type = foodData[5];
                    food.experation = foodData[7];
                    if(food.name.equals("")||food.price.equals("")||food.type.equals("")||food.experation.equals(""))
                    {
                        errors++;
                    }
                    foods.add(food);

            }
    }
    public void fixNames(ArrayList<Food> foods)
    {
        for(Food food : foods)
        {
            if(food.getName().matches("(?i)(m[a-z][a-z]k)"))
            {
                food.setName("Milk");
            }
            if(food.getName().matches("(?i)(ap[a-z][a-z][a-z]s)"))
            {
                food.setName("Apples");
            }
            if(food.getName().matches("(?i)(c[o0][o0]kies)"))
            {
                food.setName("Cookies");
            }
            if(food.getName().matches("(?i)(b[a-z][a-z][a-z]d)"))
            {
                food.setName("Bread");
            }

        }
    }

    public void combineFoodList(ArrayList<Food> foods)
    {

        for (Food food : foods)
        {

            if(food.getName().equals("Milk") && !food.getPrice().equals(""))
            {
                if(allFood.containsKey(food.getName()))
                {
                    allFood.put(food.getName(), allFood.get(food.getName())+1);
                }
                else
                {
                    allFood.put(food.getName(), 1);
                }

            }
            if(food.getName().equals("Cookies"))
            {
                if(allFood.containsKey(food.getName()))
                {
                    allFood.put(food.getName(), allFood.get(food.getName())+1);
                }
                else
                {
                    allFood.put(food.getName(), 1);
                }
            }
            if(food.getName().equals("Apples"))
            {
                if(allFood.containsKey(food.getName()))
                {
                    allFood.put(food.getName(), allFood.get(food.getName())+1);
                }
                else
                {
                    allFood.put(food.getName(), 1);
                }
            }
            if(food.getName().equals("Bread"))
            {
                if(allFood.containsKey(food.getName()))
                {
                    allFood.put(food.getName(), allFood.get(food.getName())+1);
                }
                else
                {
                    allFood.put(food.getName(), 1);
                }
            }
        }

    }
    public void getPrices(ArrayList<Food> foods)
    {
        for(Food food: foods)
        {
            if(food.getName().equals("Milk") && !food.getPrice().equals(""))
            {
                if(milkPrices.containsKey(food.getPrice()))
                {
                    milkPrices.put(food.getPrice(), milkPrices.get(food.getPrice())+1);
                }
                else
                {
                    milkPrices.put(food.getPrice(), 1);
                }

            }
            if(food.getName().equals("Cookies"))
            {
                if(cookiePrices.containsKey(food.getPrice()))
                {
                    cookiePrices.put(food.getPrice(), cookiePrices.get(food.getPrice())+1);
                }
                else
                {
                    cookiePrices.put(food.getPrice(), 1);
                }
            }
            if(food.getName().equals("Apples"))
            {
                if(applePrices.containsKey(food.getPrice()))
                {
                    applePrices.put(food.getPrice(), applePrices.get(food.getPrice())+1);
                }
                else
                {
                    applePrices.put(food.getPrice(), 1);
                }
            }
            if(food.getName().equals("Bread"))
            {
                if(breadPrices.containsKey(food.getPrice()))
                {
                    breadPrices.put(food.getPrice(), breadPrices.get(food.getPrice())+1);
                }
                else
                {
                    breadPrices.put(food.getPrice(), 1);
                }
            }
        }
    }
    public void displayData()
    {
        System.out.println("name:    Milk   seen: " +allFood.get("Milk")+ " times");
        System.out.println("=============   ============= ");
        for(String price: milkPrices.keySet())
        {
            System.out.println("Price:   "+price+"   seen: "+ milkPrices.get(price)+ " times");
            System.out.println("-------------   -------------");

        }
        System.out.println("");
        System.out.println("name:   Bread   seen: " +allFood.get("Bread")+ " times");
        System.out.println("=============   ============= ");
        for(String price: breadPrices.keySet())
        {
            System.out.println("Price:   "+price+"   seen: "+ breadPrices.get(price)+" times");
            System.out.println("-------------   -------------");

        }
        this.counter = 0;
        System.out.println("");
        System.out.println("name: Cookies   seen: " +allFood.get("Cookies")+" times");
        System.out.println("=============   ============= ");
        for(String price: cookiePrices.keySet())
        {
            System.out.println("Price:   "+price+"   seen: "+ cookiePrices.get(price)+" times");
            System.out.println("-------------   -------------");
        }
        System.out.println("");
        System.out.println("name:  Apples   seen: " +allFood.get("Apples")+" times");
        System.out.println("=============   ============= ");
        for(String price: applePrices.keySet())
        {
            System.out.println("Price:   "+price+"   seen: "+ applePrices.get(price)+" times");
            System.out.println("-------------   -------------");
        }
        System.out.println("");
        System.out.println("Errors          seen: "+errors+" times");

    }











}
