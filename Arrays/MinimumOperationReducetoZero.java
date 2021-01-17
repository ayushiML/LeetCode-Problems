package Arrays;
import java.util.*;
public class MinimumOperationReducetoZero {

    //https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603/
    
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for(int i : nums)
        {
            target += i;
        }
        if(target == 0)
            return nums.length;
        
        int len = -1;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        
        for(int i = 0 ; i< nums.length; i++)
        {
            sum += nums[i];
            
            if(sum == target)
                len = i+1;
            
            if(!map.containsKey(sum))
                map.put(sum, i);// oldest value
            //map.put(sum , i);
            
            if(map.containsKey(sum - target))
            {
                if(len < (i - map.get(sum-target) ))
                    len = i - map.get(sum-target) ;
            }
     }
        return len != -1? nums.length - len : len;
    }
}
