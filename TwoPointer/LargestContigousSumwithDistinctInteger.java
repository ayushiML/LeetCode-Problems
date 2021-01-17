package TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class LargestContigousSumwithDistinctInteger {
    public static int maxSumSubarray(int[] arr)
    {
         Set<Integer> set = new HashSet<>();
         int i = 0 ;
         int j =1;
         int cur_sum = arr[0];
         int max= cur_sum;
         set.add(arr[0]);
         while( i < arr.length -1 && j < arr.length )
         { 
           if(!set.contains(arr[j]))
           {
              cur_sum += arr[j];
              max= Math.max(max , cur_sum);
              set.add(arr[j++]);
           }
           else
           {
               cur_sum = cur_sum - arr[i];
               set.remove(arr[i++]);

           }
         }
         return max;
    }
}
