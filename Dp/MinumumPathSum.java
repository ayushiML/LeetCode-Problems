package Dp;

public class MinumumPathSum {
    //https://leetcode.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return memoziation(grid, 0 , 0 , dp);
    }
    
    public int memoziation(int[][] grid, int x , int y , int[][] dp)
    {
        if(x == grid.length-1 && y == grid[0].length-1)
            return  grid[x][y];
        if(dp[x][y] != 0)return dp[x][y];
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        if( x < grid.length-1 ) num1 = memoziation(grid, x+1, y , dp);
        if( y < grid[0].length-1)  num2 = memoziation(grid, x , y+1, dp);
        
        dp[x][y] = grid[x][y]+Math.min(num1, num2);
        
        return dp[x][y];
    }
}
