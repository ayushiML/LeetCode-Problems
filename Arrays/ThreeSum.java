package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //https://leetcode.com/problems/3sum/submissions/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
           
        for(int i = 0 ; i< nums.length-2; i++)
        {
            if(i == 0 || ( i>0 && nums[i] != nums[i-1]))
            {
                int lo = i+1;
                int high = nums.length-1;
                int sum = -(nums[i]);
                while(lo < high)
                {if(nums[lo] + nums[high] == sum)
                {
                    //List<Integer> l = new ArrayList<>();
                    ans.add(Arrays.asList(nums[i],nums[lo],nums[high]));
                    while(lo<high && nums[lo] == nums[lo+1]) lo++;
                    while(lo<high && nums[high] == nums[high-1])high--; 
                    lo++;
                    high--;
                   
                }
                 else if(nums[lo] + nums[high] > sum)
                     high--;
                 else
                     lo++;
                    
                    
                }
            }
        }
           return ans;
       }
       public static void main(String[] args) {
           
       }

}
