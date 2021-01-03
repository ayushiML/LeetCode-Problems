package Backtracking;

public class WordSearch {
    //https://leetcode.com/problems/word-search/submissions/
    public boolean exist(char[][] board, String word) {
        // dfs
        int row = board.length;
        int col = board[0].length;
        
        
        boolean[][] included = new boolean[row][col];
        for(int i =0 ; i < row ; i++)
        {
            for(int j = 0; j < col ; j++)
            {
                if(board[i][j] == word.charAt(0) && search(i , j , 0 , board, row , col , word , included));
                  return true;
            }
        }
        return false;
    }
    static int[][] dirs = {{-1,0},{0, 1}, {1, 0},{0,-1}};
    
    public boolean search(int i , int j , int index, char[][] board, int row , int col , String word, boolean[][] included)
    {
        if(index == word.length())
            return true;
        if(i >= row || i < 0 || j >= col || j < 0 || board[i][j] != word.charAt(index) || included[i][j])
            return false;
        
        included[i][j] = true;
        boolean result = false;
        for(int[] dir : dirs)
        {
            int dx = i + dir[0];
            int dy = j + dir[1];
            
            result = result || search(dx, dy , index+1, board, row, col , word, included);
               // return true;
        }
        if(result )
            return true;
        included[i][j] = false;
        
        return false;
        
        
    }
}
