package Backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

     // not backtrack, it is recursive

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
      }};
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        int n = digits.length();
        if(n == 0)
            return ans;
        backtrack("",digits,ans);
        return ans;
        
    }
    
    private static void backtrack(String combination, String digits, List<String> ans) {
         if(digits.length() == 0)
         {
            ans.add(combination);
            return;
         }
         else{
           String digit = digits.substring(0, 1);
           String letters = phone.get(digit);

           for(int i = 0 ; i < letters.length();i++)
           {
              String letter = letters.substring(i, i+1);


              backtrack(combination + letter, digits.substring(1), ans);


           }
            


         }

    }

    public static void main(String[] args) {
        String example = "2";
        List<String> l = letterCombinations(example);
       System.out.println( Arrays.toString(l.toArray()));

    }
}
