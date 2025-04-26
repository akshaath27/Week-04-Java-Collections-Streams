import java.util.*;
public class SortedSet {
    public static List<Integer>convertandSort(Set<Integer>set){
        List<Integer>list=new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public static void main(String[]args){
        Set<Integer>set=new HashSet<>(Arrays.asList(5,3,2,1));
        List<Integer>sortedList=convertandSort(set);
        System.out.println(sortedList);
    }
}
