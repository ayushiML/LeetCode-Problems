package BInarySearchProblems;

public class KthSmallestSortedMatrix
 {   // time complexity : O(n*log(max-min))

    public int kthSmallest(int[][] matrix, int k)
     {
        int n = matrix.length;
        int matrix_min = matrix[0][0];
        int matrix_max = matrix[n-1][n-1];
        
        while(matrix_min < matrix_max)
        {
            int mid = (matrix_min + matrix_max)/2;
            if(count(mid, matrix, n) < k)
                matrix_min = mid+1;
            else
                matrix_max = mid;
        }
        return matrix_max;
            
    }
    public int count(int i , int[][] matrix, int n )
    {
        int row = 0 ; 
        int col = n-1;
        int count = 0 ;
        while(row < n && col >= 0)
        {
            if(matrix[row][col] <= i )
            {
                count += col +1;
                row += 1;
                
            }
            else
                col -= 1;
        }
        return count;
    }
}
