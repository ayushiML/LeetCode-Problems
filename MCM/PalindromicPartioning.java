package MCM;

public class PalindromicPartioning {
    public static int minCut(String s) {
         
        int n = s.length();
       // dp = new int[2001][2001];
        int[][] c = new int[n][n];
        boolean[][] p = new boolean[n][n];
        if(n ==0 || n == 1)
            return 0;
         
        for(int i = 0 ; i < n ; i++)
        {
            c[i][i] = 0 ;
            p[i][i] = true;
        }
        
        for(int len = 2 ; len < n+1; len++)
        {
            for(int i = 0 ; i < n-len+1; i++)
            {
                int j = i+len-1;
                if(len == 2)
                    p[i][j] = s.charAt(i) == s.charAt(j) ? true:false;
                else
                    p[i][j] = (s.charAt(i) == s.charAt(j) ) && p[i+1][j-1];
                
                
                if(p[i][j])
                    c[i][j] = 0 ;
                else
                {
                    c[i][j] = Integer.MAX_VALUE;
                     for(int k = i ; k < j ; k++)
                     {
                         c[i][j] = Math.min(c[i][j], c[i][k] +1+c[k+1][j]);
                         
                     }
                    
                    
                    
                    
                }
                
                    
            }
        }
        return c[0][n-1];
          


        
    }
  
    public int minCutOptimized(String s) { // O(n2)
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j-1] + 1);
                }
            }
        }
        // last element in the min array will be the number of minimum cuts required
        return min[len-1];
    }
    
public static void main(String[] args) {
    String str = "aaab";
    System.out.println(minCut(str));
}
}
