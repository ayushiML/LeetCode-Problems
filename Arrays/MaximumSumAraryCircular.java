package Arrays;

public class MaximumSumAraryCircular {
    public int maxSubarraySumCircular(int[] A) {
        //https://leetcode.com/problems/maximum-sum-circular-subarray/
        int max_kadane = kadane(A);
        int max = 0 ;
        for(int i = 0 ; i < A.length;i++)
        {
            max+= A[i];
            A[i] = -A[i];
        }
        max = max + kadane(A);
        if(max == 0)
            return max_kadane;
        
        return max > max_kadane ? max:max_kadane;
    }
    
    
    public int kadane(int[] a)
    {
        int max_so_far = a[0];
        int max_ending_here = a[0];
        
        for(int i = 1 ; i < a.length;i++)
        {
            max_ending_here += a[i];
            max_ending_here = Math.max(max_ending_here , a[i]);
            
            if(max_ending_here > max_so_far)
                max_so_far = max_ending_here;
            
            
        }
        return max_so_far;
    }
}
