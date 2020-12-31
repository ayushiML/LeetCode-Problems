package Dp;

public class UniquePaths {
    //https://leetcode.com/problems/unique-paths/
    public boolean isSafe(int M , int N , int k , int l)
    {
        if(k >= 0 && k < M && l >= 0 && l < N)
            return true;
        return false;
        
    }
  
    public int uniquePaths(int m, int n) {
        //int unique = 0 ;
       int[][] dp = new int[m][n];
         for (int i = 0; i < m; i++) 
            dp[i][0] = 1; 
  
      
        for (int j = 0; j < n; j++) 
            dp[0][j] = 1;
       for (int i= 1; i < m; i++) 
       {
           for (int j = 1; j < n; j++) 
           {
              dp[i][j] = dp[i-1][j] + dp[i][j-1];
           }
       }
        
        return dp[m-1][n-1];
    }
}
