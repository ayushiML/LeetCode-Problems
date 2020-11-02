package Graph;

public class NumberOfIslands {
     
        static int rowNbr[] = new int[] { -1, 0, 1, 0}; 
       static int colNbr[] = new int[] { 0, 1, 0, -1};
         
       //-1 for already visited element
       static boolean  isSafe(int Row, int Col, int i , int j, char[][] grid)
       {
           if(i < 0 || i >=Row || j < 0 || j >=Col || grid[i][j] == '2' || grid[i][j] == '0')
               return false;
           return true;
       }
      // int[][] ref;
       public static int numIslands(char[][] grid) {
          // ref= grid;
           int row = grid.length;
           int col = grid[0].length;
            int count = 0 ;
           for(int i = 0 ; i < row; i++ )
           {
               for(int j = 0 ; j <col ; j++)
               {
                   if(grid[i][j] == '1')
                   {
                       bfs(grid, i , j, row, col);
                       count++;
                   }
               }
           }
           return count;
           
           
           
       }
       public static void bfs(char[][] grid, int i , int j , int R, int C)
       {
           for(int m = 0 ; m < 4 ; m++)
           {
               
                   if(isSafe(R,C,i+rowNbr[m], j+colNbr[m],grid))
                   {
                       grid[i+rowNbr[m]][j+colNbr[m]] = '2';
                       bfs(grid,i+rowNbr[m],j+colNbr[m],R,C );
                   }
               
           }
           
        }
        public static void main(String[] args) {
            
        }
   }  
