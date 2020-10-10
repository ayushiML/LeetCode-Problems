package LCS;

import java.util.Stack;

class PrintLongestCommonSubsequence {
    public static void main (String[] args)  
    { 
        String X = "AGGTAB"; 
        String Y = "GXTXAYB"; 
        
        lcs(X, Y); 
    }

    private static void lcs(String text1, String text2) {
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

          Stack<Character> s = new Stack<>();
          int i = n1 ; int j = n2;
          while(i>0 && j>0)
          {
              if(text1.charAt(i-1) == text2.charAt(j-1))
              {
                    s.push(text1.charAt(i-1));
                    i--;
                    j--;
              }
              else{
                  if(dp[i-1][j] > dp[i][j-1])
                  i--;
                  else
                  j--;
              }
          }
          while(!s.isEmpty())
          {
              System.out.print(s.pop());
          }


    }


}