import java.util.*;
public class Duplicates {
    public static <T> List<T>removeDuplicates(List<T> list)
    {
        Set<T> seen=new LinkedHashSet<>();
        seen.addAll(list);
        return new ArrayList<>(seen);

    }
    public static void main(String[] args){
        List<Integer>input=Arrays.asList(3,1,2,2,3,4);
        List<Integer>result=removeDuplicates(input);
        System.out.println(result);
    }


}
