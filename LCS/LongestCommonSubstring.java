package LCS;

public class LongestCommonSubstring { 
     
       
        static int LCSubStr(char X[], char Y[], int n1, int n2)  
        { 
            int[][] dp = new int[n1+1][n2+1];
        for(int i = 0 ; i <= n1; i++)
          dp[i][0] = 0;
        for(int i = 0 ; i <= n2; i++)
          dp[0][i] = 0;

          int max  =Integer.MIN_VALUE;
        for(int i = 1 ; i <= n1; i++)
          for(int j = 1 ; j <= n2; j++)
          {
              if(X[i-1] == Y[j-1] )
              {
                  dp[i][j] = 1+ dp[i-1][j-1];
                  if(max < dp[i][j]) max= dp[i][j];
              }
              else{
                  dp[i][j] = 0 ;
              }

          }
          return max;
        } 
          
        // Driver Program to test above function 
        public static void main(String[] args)  
        { 
            String X = "OldSite:GeeksforGeeks.org"; 
            String Y = "NewSite:GeeksQuiz.com"; 
      
            int m = X.length(); 
            int n = Y.length(); 
      
            System.out.println("Length of Longest Common Substring is "
                    + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n)); 
        } 
    }
