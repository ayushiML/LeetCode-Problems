package Backtracking;

import java.util.*;

public class AllPalindromePartiontion {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = s.length();
        
        backtracking(result, ans , 0,n,s);
        return result;
        
    }
    public void backtracking(List<List<String>> result , List<String> ans , int start , int n , String s)
    {
        if(start >= n)
        {
            result.add(new ArrayList<String>(ans));
            return;
            
        }
        for(int i = start ; i <  n ; i++)
        {
             if(isPalindrome(s, start, i))
             {
                 ans.add(s.substring(start, i+1));
                 backtracking(result , ans , i+1 , n , s);
                 ans.remove(ans.size()-1);
             }
        }
           
    }
    public boolean isPalindrome(String input , int i , int j )
    {
        while( i <= j )
        {
            if(input.charAt(i) != input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
