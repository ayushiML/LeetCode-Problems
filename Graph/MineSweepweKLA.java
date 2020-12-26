package Graph;

public class MineSweepweKLA {
    public static boolean isSafe(int i , int j,  int row , int col)
    {
        return (i >= 0 && i < row && j >= 0 && j < col); 
    }
    public static boolean isCorrectMineSweeper(char[][] grid)
    {

        int[][] dirs = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        int n = grid.length;
        int m = grid[0].length;
        // ascii value 0-9 : 48 to 57  1 to 8 : 49 to 56
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; i++)
            {
                if( grid[i][j] >= 49 && grid[i][j]<= 56)
                   if(grid[i][j] -'0'== count(grid, i , j, dirs, n , m))
                      continue;
                   else
                      return false;
            }
        }
        return true;
     }
    private static int count(char[][] grid, int i, int j, int[][] dirs, int row, int col) {
    int count =0 ;
       for(int[] dir : dirs)
       {
           int x = i + dir[0];
           int y = j + dir[1];

           if(isSafe(x, y , row, col) && grid[x][y] == 70)
             count++;
       }
       return count;



    }
}
