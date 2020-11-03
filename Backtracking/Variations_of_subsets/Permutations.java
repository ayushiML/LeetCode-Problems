package Backtracking.Variations_of_subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Permutations {
    //https://leetcode.com/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
            List<Integer> set = new ArrayList<>();
            backtrack(ans, set,nums);
            return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> set, int[] nums) {
        if(set.size() == nums.length)
        {
            ans.add(new ArrayList<>(set));
            return ;
        }
        for(int i = 0 ; i < nums.length; i++)
        {
            if(set.contains(nums[i]))
            continue;
            set.add(nums[i]);
            backtrack(ans, set, nums);
            set.remove(set.size()-1);
        }
    }
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1,2,3};
            List<List<Integer>> ans=p.permute(nums);
            System.out.println(Arrays.toString(ans.toArray()));
    }
}
