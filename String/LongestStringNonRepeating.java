package String;

import java.util.Arrays;

public class LongestStringNonRepeating {
    public static int maxLength(String s )
    {   int[] last = new int[128];
        int start = 0 ; 
        int n = s.length();
        if( n== 0|| n==1)
        return n;
        Arrays.fill(last,-1);
        //int curr_len  = 1;
        int result  =1;
        
        for(int i = 0 ; i < n ; i++)
        {
            int value = last[s.charAt(i)];
            start = Math.max(start, value+1);
            result = Math.max(result,i-start+1);
            last[s.charAt(i)] = i;

        }
        return result;
    }
    
}
