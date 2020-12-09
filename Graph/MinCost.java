package Graph;

public class MinCost {
     public int minCost(int[][] grid , int m , int n )
     {  //int min = Integer.MAX_VALUE;
        int row = grid.length;
        int col = grid[0].length;
// using dp solution
        //space optimized by using grid modification 

        for(int i = 1 ; i < row; i++)
        {
            for(int j = 1 ; j < col ; j++)
            {
                grid[i][j] += Math.min(grid[i-1][j] , Math.min(grid[i][j-1], grid[i-1][j-1]));
            }
        }






        return grid[row-1][col-1];
     }
}
