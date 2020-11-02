import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    
        public static boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;

            for(int i = 1; i <= n ; i++)
            {
                for(int j = 0 ; j < i; j++)
                {
                    if(dp[j] && wordDict.contains(s.substring(j,i)))
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];


            //return false;

        }

        public static void main(String[] args) {
            String s = "applepenapple";
            List<String> l = new ArrayList<String>() {
                {
                    add("apple");
                    add("pen");
                }
            };
            System.out.println(Arrays.toString(l.toArray()));
            System.out.println(wordBreak(s, l));
        }
    
}
