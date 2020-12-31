package Backtracking.Variations_of_subsets;
import java.util.*;
public class CombinationSum {
    //https://leetcode.com/problems/combination-sum/submissions/
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(list, new ArrayList<>(), arr, target, 0);
        return list;
    }
      public void backtrack(List<List<Integer>> list , List<Integer> res , int[] arr , int target, int start)
      {
          if(target < 0 )
               return;
         else if(target == 0)
          {
              list.add(new ArrayList<>(res));
              return;
          }
          else{
          for(int i = start ; i < arr.length;i++)
          {
              res.add(arr[i]);
              backtrack(list, res, arr, target-arr[i], i);
              res.remove(res.size()-1);
          }
        
      }
    }
}
