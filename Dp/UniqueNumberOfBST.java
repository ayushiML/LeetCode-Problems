package Dp;

public class UniqueNumberOfBST {
    public int numTrees(int n) {
        // n th catalan number
        // => (2n !)/((n+1)! *n!)
        
        //https://leetcode.com/problems/unique-binary-search-trees/
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ; i <= n ;i++)
        {
            for(int j = 1 ; j <= i ; j++)
            {
                dp[i] = dp[i] + dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
