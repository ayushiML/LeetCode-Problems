package Arrays;
import java.util.*;
public class CheckarrayFormation {
    //https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++)
        {
            map.put(arr[i], i);
        }
        for(int[] piece : pieces)
        {
            if(!map.containsKey(piece[0])) return false;
            for(int i = 1 ; i < piece.length; i++)
            {
                if(!map.containsKey(piece[i])) return false;
                if(map.get(piece[i])-map.get(piece[i-1]) != 1) return false;
                
            }
        }
        return true;
    }
}
