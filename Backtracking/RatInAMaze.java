package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}};  

        printPath(m, m[0].length);
    }
    
    public static ArrayList<String> printPath(int[][] m, int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        boolean[][] visited = new boolean[n][n];
        backtrack(m, n, 0, 0, ans, sb, visited);

        return ans;



    }

    private static void backtrack(int[][] m, int n, int row, int col, List<String> ans, StringBuilder sb,
            boolean[][] visited) {


                if(!isSafe(row, col, visited, m, n))
                return ;

                if(row == n-1 && col == n-1)
                {
                    String s = sb.toString();
                    ans.add(s);
                    return;
                }
                visited[row][col] = true;

                if(isSafe(row-1, col, visited, m, n))
                {
                    sb.append('U');
                    backtrack(m, n, row-1, col, ans, sb, visited);
                    sb.deleteCharAt(sb.length()-1);
                }
                if(isSafe(row, col-1, visited, m, n))
                {
                    sb.append('L');
                    backtrack(m, n, row, col-1, ans, sb, visited);
                    sb.deleteCharAt(sb.length()-1);
                }
                if(isSafe(row+1, col, visited, m, n))
                {
                    sb.append('D');
                    backtrack(m, n, row+1, col, ans, sb, visited);
                    sb.deleteCharAt(sb.length()-1);
                }
                if(isSafe(row, col+1, visited, m, n))
                {
                    sb.append('R');
                    backtrack(m, n, row, col+1, ans, sb, visited);
                    sb.deleteCharAt(sb.length()-1);
                }

                visited[row][col] = false;
                
    }

    private static boolean isSafe(int row, int col, boolean[][] visited, int[][] m, int n) {
        if(row == -1 || col == n || row == n|| col == -1|| visited[row][col] == true || m[row][col] == 0)
          return false;
        
        return true;
    }

}
