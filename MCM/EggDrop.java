package MCM;

public class EggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        
        for(int i = 0 ; i <= K ; i++)
        {
            dp[i][0]= 0 ;
            dp[i][1] = 1;
            
        }
        for(int i = 0 ; i <= N; i++)
        {
            dp[1][i] = i;
            
        }
        int res;
         for(int i = 2 ; i <= K ; i++)
         {
              for(int j = 2 ; j <= N ; j++)
              {
                  dp[i][j] = Integer.MAX_VALUE;
                  for(int x = 1 ; x <=j; x++)
                  {
                      res = 1 + Math.max(dp[i][j-x],dp[i-1][x-1]);
                      if(res < dp[i][j])
                          dp[i][j] = res;
                      
                  }
              }
         }
        return dp[K][N];
        
    }


    
}
