package Backtracking;
import java.util.*;
public class PermuatationOfParanthesis {
    //https://leetcode.com/problems/generate-parentheses/submissions/
    List<String> output = new LinkedList<>();
    public void backtrack(String s, int n, int open, int close)
    {
        if(s.length() == 2*n)
        { output.add(s);
         return;
        }
        
        if(open < n)
            backtrack(s+"(",n,open+1,close);
        if(close<open)
            backtrack(s+")",n,open, close+1);
        
    }
    public List<String> generateParenthesis(int n) {
        
        if(n != 0)
            backtrack("", n, 0, 0);
        return output;
    }
}
