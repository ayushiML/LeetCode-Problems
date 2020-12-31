package Arrays;

//import javax.lang.model.util.ElementScanner6;

public class RangeInSortedArray {
    int lower = -1;
    int upper = -1;
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        if(n == 0 )
            return new int[]{lower, upper};
        lower = binarySearch( nums, target, 0 , n, true);
        if(lower == n || nums[lower] != target)
            return new int[]{-1,-1};
        upper = binarySearch(nums, target, 0, n, false);
        
        
        return new int[]{lower, upper-1};
    }

    private int  binarySearch(int[] nums, int target, int l , int r , boolean lower ) {
        if( l > r)
           return -1;
        while(l < r)
        {
        int mid = l +(r-l)/2;
        if(nums[mid] > target || (lower && target == nums[mid]))
            r = mid;
         else
         {
             l= mid +1;
             
         }
              
       
    }   

    return l;

    }
    
}
