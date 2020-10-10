package LCS;


public class PrintLCSuperSequence {
    //https://www.geeksforgeeks.org/shortest-common-supersequence/
    //LCS #4 
    public static void main(String args[]) 
    { 
    String X = "AGGTAB"; 
    String Y = "GXTXAYB"; 
     longestCommonSubsequence(X,Y);
    System.out.println("Length of the shortest " + 
                             "supersequence is " + 
                      shortestSuperSequence(X, Y)); 
    }

    private static int[][] dp;
    public static void longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        dp = new int[n1+1][n2+1];
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
        //return dp[n1][n2];
    }
    private static String shortestSuperSequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        //Stack<Character> s = new Stack<>();
        StringBuffer str = new StringBuffer("");
        int i = n ;int j = m ;
        while(i >0 && j >0)
        {
            if(x.charAt(i-1) == y.charAt(j-1))
            {
                str.append(x.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1])
                {
                    str.append(x.charAt(i-1));
                    i--;
                }
                else if(dp[i-1][j] < dp[i][j-1])
                {
                    str.append(y.charAt(j-1));
                    j--;

                }
                else
                {
                    str.append(x.charAt(i-1));
                    str.append(y.charAt(j-1));
                    i--;
                    j--;
                }
            }
            while(i > 0)
            str.append(x.charAt(i-1));
            while(j >0 )
            str.append(y.charAt(j-1));
            String s= str.toString();
            return s;
        }

        return "ans";
    }


}
