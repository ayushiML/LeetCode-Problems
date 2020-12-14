package MCM;
public class BurstBallons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
            if(n == 0 )
                return 0 ;
        int[][] dp = new int[n][n];
            
        for(int len = 0 ; len < n ; len++ )
        {
         for(int i = 0 ; i + len < n ; i++)
         {
             int j = i+len;
             for(int k = i ; k <= j ; k++ )
             {
                 // nums[-1] i ==0
                 int leftmul = (i == 0)? 1:nums[i-1];
                 // nums[n] = 1 j = n-1  ? int 
                 int rightmul = (j == n-1) ? 1 : nums[j+1];
                 
                 
                 int left = (i==k)? 0: dp[i][k-1];
                 int right = (k ==  j)? 0: dp[k+1][j];
                 
                 dp[i][j] = Math.max(dp[i][j], left + right + leftmul *nums[k] *rightmul);
               //  max= Math.max(mx, dp[i][k] +dp[k+1][j] + nums[i-1]*nums[k]*nums[j+1]);
                 
                 
                 
                 
             }
             
         }
            
        }
            return dp[0][n-1];
    }
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
}
