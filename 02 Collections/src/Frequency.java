import java.util.*;
public class Frequency {
    public static Map<String,Integer>countFrequencies(List<String>items)
    {
        Map<String,Integer>frequencymap=new HashMap<>();
        for(String item:items){
            if(frequencymap.containsKey(item))
            {
                frequencymap.put(item,frequencymap.get(item)+1);
            }
            else {
                frequencymap.put(item,1);
            }
        }
        return frequencymap;
    }
    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequencies(input);

        System.out.println(result);
    }

}
