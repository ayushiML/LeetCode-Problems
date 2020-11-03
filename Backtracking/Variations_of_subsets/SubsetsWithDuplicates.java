package Backtracking.Variations_of_subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import sun.security.util.ArrayUtil;
public class SubsetsWithDuplicates {
    //https://leetcode.com/problems/subsets-ii/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
            //int n = nums.length;
            Arrays.sort(nums);
            List<Integer> set = new ArrayList<>();
            backtrack(ans, set, 0 ,nums);
            return ans;
  
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> set, int start, int[] nums) {
        ans.add(new ArrayList<>(set));

        for(int i = start ; i <nums.length;i++)
        {
            if(i > start  && nums[i] == nums[i-1])
            continue;

            set.add(nums[i]);
            backtrack(ans, set, i+1, nums);
            set.remove(set.size()-1);
        }
        
	}
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubsetsWithDuplicates subsetsWithDuplicates = new SubsetsWithDuplicates();
        
        List<List<Integer>> ans =subsetsWithDuplicates.subsetsWithDup(nums);
        System.out.println(Arrays.toString(ans.toArray()));

    }

}
