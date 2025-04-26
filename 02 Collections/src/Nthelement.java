import java.util.*;
public class Nthelement {
    public static <T>T getNthfromend(LinkedList<T>list,int n)
    {
        if(list==null||n<=0){
            throw new IllegalArgumentException("invalid");
        }
        Iterator<T>fast= list.iterator();
        Iterator<T>slow= list.iterator();

        for(int i=0;i<n;i++){
            if(fast.hasNext()){
                fast.next();
            }
            else{
                throw new IllegalArgumentException("N is larger");
            }
        }
        while(fast.hasNext())
        {
            fast.next();
            slow.next();
        }
        return slow.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result =getNthfromend(list, n);
        System.out.println("Nth element from end: " + result);  // Output: D
    }
}
