package LCS.PalindromicQuestions;

import LCS.LongestCommonSubstring;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // for length 1
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;

        }
        // for length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        char[] ch = s.toCharArray();
        // forlen : 3 to n
        // n-k +1

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) { //
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (k > maxLen) {
                        maxLen = k;
                        start = i;
                    }
                }

            }
        }
        // String s
        return s.substring(start, start + maxLen);

    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
}
