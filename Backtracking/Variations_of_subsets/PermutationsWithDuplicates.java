package Backtracking.Variations_of_subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PermutationsWithDuplicates {
    //https://leetcode.com/problems/permutations-ii/
    public List<List<Integer>> permutewithduplicates(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            List<Integer> set = new ArrayList<>();
            backtrack(ans, set,nums,new boolean[nums.length]);
            return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> set, int[] nums,boolean[] used) {
        if(set.size() == nums.length)
        {
            ans.add(new ArrayList<>(set));
            return ;
        }
        for(int i = 0 ; i < nums.length; i++)
        {   if(used[i] ||(i >0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            used[i] = true;

            set.add(nums[i]);
            backtrack(ans, set, nums,used);
            used[i] = false;
            set.remove(set.size()-1);
        }
    }
    public static void main(String[] args) {
        PermutationsWithDuplicates p = new PermutationsWithDuplicates();
        int[] nums = {1,2,2};
            List<List<Integer>> ans=p.permutewithduplicates(nums);
            System.out.println(Arrays.toString(ans.toArray()));
    }
}
