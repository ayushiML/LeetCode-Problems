package String;

import java.util.Arrays;

public class RemoveConsecutiveDuplicates {
    static void removeDuplicates(char[] S)  
    { 
        int n = S.length; 
  
        // We don't need to do anything for 
        // empty or single character string. 
        if (n < 2)  
        { 
            return; 
        } 
  
        // j is used to store index is result 
        // string (or index of current distinct 
        // character)  
        int j = 0; 
  
        // Traversing string  
        for (int i = 1; i < n; i++)  
        { 
            // If current character S[i] 
            // is different from S[j] 
            if (S[j] != S[i]) 
            { 
                j++; 
                S[j] = S[i]; 
            } 
        } 
        System.out.println(Arrays.copyOfRange(S, 0, j + 1)); 
    }
}
