package Challenge;

public class SquaresOfSortedArray {
    //https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/
    public static int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int low = 0 ; 
        int high = n-1;
        
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(Math.abs(nums[low]) >= Math.abs(nums[high]))
               {
                   res[i] = nums[low] * nums[low];
                   low++;
                   
               }
               else 
               {
                   res[i] = nums[high] * nums[high];
                   high--;
               }
        }
               return res;
    }
    public static void main(String[] args) {
        
    }
}
