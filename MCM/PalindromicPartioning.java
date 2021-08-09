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
        int n = s.length();
        if(n == 0 || n == 1)
            return 0 ;
        
        int[] cuts = new int[n];
        boolean[][] p = new boolean[n][n];
        
        
        for(int len = 0 ; len < n ; len++){
            cuts[len] = len;
            for(int i = 0 ; i <= len;  i++)
            {
                if(s.charAt(i) == s.charAt(len) &&(i+1>len-1 || p[i+1][len-1]))
                {
                    p[i][len] = true;
                    cuts[i] = i == 0 ? 0:Math.min(cuts[i],1+cuts[i-1]);
                }
            }
        }
        return cuts[n-1];
    }
    
public static void main(String[] args) {
    String str = "aaab";
    System.out.println(minCut(str));
}
}
