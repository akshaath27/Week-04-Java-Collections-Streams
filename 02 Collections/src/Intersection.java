import java.util.*;
public class Intersection {
    public static <T>Set<T>union(Set<T>set1,Set<T>set2){
        Set<T> result=new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // Copy all elements from set1
        result.retainAll(set2);              // Keep only elements also in set2
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> unionResult = union(set1, set2);
        Set<Integer> intersectionResult = intersection(set1, set2);

        System.out.println("Union: " + unionResult);         // Output: [1, 2, 3, 4, 5]
        System.out.println("Intersection: " + intersectionResult); // Output: [3]
    }
}


