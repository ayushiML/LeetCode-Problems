package Greedy;

import java.util.*;
//https://www.interviewbit.com/problems/distribute-candy/
public class ChocolateDistribution {
    public int candy(ArrayList<Integer> A) {
        int[] candy = new int[A.size()];
        
        int n = A.size();
        Arrays.fill(candy,1);
        
        for(int i = 1 ; i < n ; i++)
        {
            if( A.get(i) > A.get(i-1))
             {
                 candy[i] = candy[i-1]+1;
             }
        }
        for(int i = n-2 ; i >= 0 ; i --)
        {
            if(A.get(i) > A.get(i+1))
              candy[i] = Math.max(candy[i] , candy[i+1] +1);
              
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            ans+= candy[i];
        }
        return ans;
        
    } 
}
