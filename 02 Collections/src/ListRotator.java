import java.util.*;
public class ListRotator {
    public static <T> List<T>rotateLeft(List<T> list,int positions){
        int size=list.size();
        if(size==0)return list;
        positions=positions%size;
        List<T> rotated=new ArrayList<>();
        rotated.addAll(list.subList(positions,size));
        rotated.addAll(list.subList(0,positions));

        return rotated;
    }
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotated = rotateLeft(input, rotateBy);
        System.out.println("Rotated List: " + rotated);
    }

}
