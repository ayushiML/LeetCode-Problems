package Arrays;

public class SearchInSortedmatrix {
    //https://leetcode.com/problems/search-a-2d-matrix/submissions/
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col = matrix[0].length;
        
        if( target < matrix[0][0] || target > matrix[row-1][col-1])
            return false;
        int j = col-1;
        int i = 0;
        while( i < row && j >= 0)
        {
            if( target == matrix[i][j] )
                return true;
            else if( target > matrix[i][j])
                i++;
            else
                j--;
                
        }
        return false;
    }
}
