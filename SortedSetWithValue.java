import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortedSetWithValue {
    public static void main(String[] args) {
        SortedSet<Map.Entry<Integer, Integer>> set = new TreeSet<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer,Integer>>(){
                @Override
                public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b)
                {
                    return a.getValue().compareTo(b.getValue());

                }
                
            });
            
            SortedMap<Integer, Integer> myMap = new TreeMap<Integer, Integer>();
    myMap.put(1, 6868);
    myMap.put(2, 78);
    myMap.put(3, 11);
    myMap.put(4, 75897);
    set.addAll(myMap.entrySet());
    System.out.println(set);


    }
}
