package Arrays;

import java.util.*;

public class LargestSubArraywithEqual0and1 {
    //https://leetcode.com/problems/contiguous-array/
    public int findMaxLength(int[] nums) {
        int n = nums.length;
          if( n <= 1)
              return 0;
          Map<Integer, Integer> map = new HashMap<>();
          
          int max = 0 ;
          int sum = 0;
          int startindex = -1;
          
          map.put(0, -1);
          for(int i = 0 ; i < n ; i++)
          {
              if(nums[i] == 0)
                  sum = sum-1;
              else
                  sum = sum+1;
              
              if(map.containsKey(sum))
              {
                 // max = Math.max(max, i- map.get(sum));
                  if(max < i - map.get(sum))
                  {
                      startindex = map.get(sum) +1;
                      max= i - map.get(sum);
                  }
                  
              }
              else
                  map.put(sum , i);
          }
          System.out.println("max length :"+ max +"  starting from "+ startindex +" to "+(max+startindex-1));
          return max;
          
      }
}
