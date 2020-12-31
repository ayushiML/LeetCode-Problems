package Dp;

public class UniquePathsII {
    //https://leetcode.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return 0;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < m ; i++)
        {  if(grid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for(int i = 0 ; i < n ; i++)
        {  if(grid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        for(int i = 1 ; i < n ; i++)
        {  for(int j = 1 ; j < m ; j++)
        {
            if(grid[i][j] != 1)
            {
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        }
        return dp[n-1][m-1];
        
    }
}
