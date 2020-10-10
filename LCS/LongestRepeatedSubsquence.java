package LCS;
//https://www.geeksforgeeks.org/longest-repeated-subsequence/


public class LongestRepeatedSubsquence {
    public static void main(String[] args) { 
        String seq = "aaa"; 
        int n = seq.length(); 
        System.out.printf("The length of the LPS is %d", lrs(seq, n)); 
}

private static int lrs(String seq, int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i = 0 ; i <= n; i++)
          dp[i][0] = 0;
        for(int i = 0 ; i <= n; i++)
          dp[0][i] = 0;
          for(int i = 1 ; i <= n; i++) 
          {
              for(int j = 1; j <=n ; j++)
              {
                  if(i!=j && seq.charAt(i-1)== seq.charAt(j-1))
                  dp[i][j]= 1+dp[i-1][j-1];
                  else
                  dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);

              }
          }
		return dp[n][n];
    }
}
