import java.util.*;
public class SetEqualityChecker {
    public static <T> boolean areSetsequal(Set<T>set1,Set<T>set2){
        if(set1==null || set2==null){
            return false;
        }
        return set1.equals(set2);
    }
    public static void main(String[]args){
        Set<Integer>set1=new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer>set2=new HashSet<>(Arrays.asList(3,2,1));
        boolean result=areSetsequal(set1,set2);
        System.out.println(result);
    }
}
