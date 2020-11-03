import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    //https://leetcode.com/problems/insert-delete-getrandom-o1/
        static List<Integer> l;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        l = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, l.size());
        l.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null)
            return false;

        int lastelement = l.get(l.size() - 1);
        // int lastIndex = map.get(last);

        l.set(index, lastelement);
        map.put(lastelement, index);
        map.remove(val);
        l.remove(l.size() - 1);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rm = new Random();
        int x = rm.nextInt(l.size());
        return l.get(x);

    }

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.insert(6);
        r.insert(7);
        r.insert(1);
        r.remove(1);
        System.out.println(Arrays.toString(l.toArray()));

       System.out.println(r.getRandom());
        }
    
}
