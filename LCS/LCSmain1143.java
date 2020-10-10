package LCS;

class LCSmain1143
 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0 ; i <= n1; i++)
          dp[i][0] = 0;
        for(int i = 0 ; i <= n2; i++)
          dp[0][i] = 0;
        for(int i = 1 ; i <= n1; i++)
          for(int j = 1 ; j <= n2; j++)
          {    if(text1.charAt(i-1) == text2.charAt(j-1))
                 dp[i][j] = 1+ dp[i-1][j-1];
                else
                {
                    dp[i][j]= Math.max(dp[i][j-1], dp[i-1][j]);
                }
          }
        




        return dp[n1][n2];



    }
    public static void main(String[] args) 
    { 
     // LCSmain1143 lcs = new LCSmain1143(); 
      String s1 = "AGGTAB"; 
      String s2 = "GXTXAYB"; 
    
      
    
      System.out.println("Length of LCS is" + " " + 
                                    longestCommonSubsequence( s1, s2) ); 
    }
}