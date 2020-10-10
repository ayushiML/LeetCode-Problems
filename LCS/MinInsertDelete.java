package LCS;

public class MinInsertDelete {
    //https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
    public static void main(String[] args)
    {
        String str1 = new String("heap");
        String str2 = new String("pea");
       
          // Function Call
        printMinDelAndInsert(str1, str2);
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n2; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n1; i++)
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        return dp[n1][n2];
    }

    private static void printMinDelAndInsert(String str1, String str2) {
        int lcs = longestCommonSubsequence(str1, str2);
        int m = str1.length();
        int n = str2.length();
        System.out.println("Minimum number of "
                           + "deletions = ");
        System.out.println(m - lcs);
 
        System.out.println("Minimum number of "
                           + "insertions = ");
        System.out.println(n - lcs);
    }
}
