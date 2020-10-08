import java.util.HashMap;
import java.util.Map;

class Solution560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int res = 0 ; 
        int curr_sum = 0 ;int n = nums.length;
        for(int i = 0; i < n ; i++)
        {curr_sum += nums[i];
         
         
         //curr_sum equal to k
         if(curr_sum == k)
             res++;
         
         if(m.containsKey(curr_sum-k))
         {
             res+= m.get(curr_sum - k );
             
         }
         Integer count = m.get(curr_sum);
         
            if(count == null)
                m.put(curr_sum, 1);
           else
               m.put(curr_sum,count +1);
         
            
            
        }
         return res;
    }
    public static void main(String[] args)
    {
 
        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        //int n = arr.length;
        System.out.println(subarraySum(arr,  sum));
    }
}