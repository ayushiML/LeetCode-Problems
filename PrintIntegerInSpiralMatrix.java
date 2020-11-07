import java.util.ArrayList;
import java.util.List;

public class PrintIntegerInSpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // k starting row index 
            //m ending row index
            //l starting colum index
            //n ending column index
            // number of square : 4 -2 3-2 2-1 1-1 floor(n/2) +1
            List<Integer> ans = new ArrayList<Integer>();
            int m = matrix.length;
            if( m == 0)
                return ans;
            int n = matrix[0].length;
            
            int k = 0 ; int l =0 ; int i= 0;
            while( k < m &&  l < n)
            {
                for(i = l ; i < n; i++)
                { ans.add(matrix[k][i]);
                  
                }
                k++;
                for(i = k ; i < m ; i++)
                {
                    ans.add(matrix[i][n-1]);
                   
                }
                n--;
                if(k < m)
                {
                    for(i = n-1; i >= l ; i--)
                    {ans.add(matrix[m-1][i]);
                    }
                    m--;
                }
                if( l < n)
                {
                    for(i = m-1; i >= k ; i--)
                        ans.add(matrix[i][l]);
                    l++;
                }
                
                
                
                
            }
            return ans;
        }
    }
}
