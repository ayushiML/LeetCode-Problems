package LCS.PalindromicQuestions;

class LongestPalindromicSubsquence
{//LPS = LCS(a, reverse(a))
  //question: https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
  
  public static void main(String[] args) { 
    String seq = "abc"; 
    int n = seq.length(); 
    System.out.printf("The length of the LPS is %d", lps(seq, 0, n - 1)); 

}

private static Object lps(String str, int i, int j) {
    StringBuffer sbr = new StringBuffer(str); 
   
    sbr.reverse();
    String b = sbr.toString();
    
	return longestCommonSubsequence(str, b);
}
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

}