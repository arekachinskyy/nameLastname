package lecture6.ThirdTask;

import java.util.*;

public class Products {
    public static void main(String[] args) {
        Map<String, String> list = new HashMap<>();
        list.put("banana", "fruit");
        list.put("apple", "fruit");
        list.put("pinaple", "fruit");
        list.put("cheese", "milk");
        list.put("hot-dog", "fastfood");
        list.put("tea", "drink");
        list.put("pizza", "fastfood");
        list.put("burger", "fastfood");
        list.put("pepper", "vegetable");
        list.put("peanuts", "nuts");

        Set duplicates = new HashSet();
        Iterator<Map.Entry<String, String>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> val = iterator.next();
            String dup = val.getValue();
            if (!duplicates.add(dup))
                iterator.remove();
        }

        System.out.println(list.entrySet());

    }
}
