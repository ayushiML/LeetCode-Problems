package Challenge;

public class RemoveRepeatedCharcters {
    //Smallest Subsequence of Distinct Character
    // https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
    public static String smallestSubsequence(String s) {
     char[] ch = s.toCharArray();
     int n = ch.length;
     int[] lastIndex = new int[26];
     for(int i = 0;i < n;i++)
     {
         lastIndex[s.charAt(i)-'a']= i;
     }
     
    boolean[] used = new boolean[26];
     StringBuffer sbr = new StringBuffer("");
      for(int i = 0 ; i < n ;i++)
      {
          if(used[ch[i]-'a'])
           continue;

           while(sbr.length()>0 && sbr.charAt(sbr.length()-1) > ch[i] && lastIndex[sbr.charAt(sbr.length()-1) -'a'] > i)
           {
               used[sbr.charAt(sbr.length()-1) -'a'] = false;
               sbr.deleteCharAt(sbr.length()-1);
           }
           sbr.append(ch[i]);
           used[ch[i]-'a']= true;
      }

     return sbr.toString();

    }

    public static void main(String[] args) {
        String a = "cbcadcbc";

        System.out.println(smallestSubsequence(a));
     
 }
}
