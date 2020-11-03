package Backtracking.Variations_of_subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    
        //private boolean add;

		public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            //int n = nums.length;
            Arrays.sort(nums);
            List<Integer> set = new ArrayList<>();
            recursive(ans, set, 0 ,nums);


            return ans;
            
            
        }

        private void recursive(List<List<Integer>> ans, List<Integer> set, int start, int[] nums) {
           
                System.out.println("reached"+Arrays.toString(set.toArray()));
                ans.add(new ArrayList<>(set));
                   
               for(int i = start ; i < nums.length ;i++)
               {

               set.add(nums[i]);
               recursive(ans,set , i+1,nums);
               set.remove(set.size()-1);
               }
               //return;



        }

        public static void main(String[] args) {
            int[] nums = {1,2,3};
            SubSets sets = new SubSets();
            List<List<Integer>> ans=sets.subsets(nums);
            System.out.println(Arrays.toString(ans.toArray()));

        }
    
}
