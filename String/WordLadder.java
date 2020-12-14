package String;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0 ; 
        int wordLen = beginWord.length();
        if(!wordList.contains(endWord))
            return 0;
       Queue<String> q = new LinkedList<>();
       q.add(beginWord);
       while(!q.isEmpty())
       {
           ++level;
           int size= q.size();
           for(int i = 0 ; i < size; i++)//  string present in Queue/ at that level
           {   String wordS = q.remove();
               char[] word = wordS.toCharArray();
               //char[] original = word;
               for(int j = 0 ; j < wordLen; j++)
               {    char original = word[j];
                   for(char c = 'a' ; c <= 'z'; c++)
                   {
                        word[j] = c;
                        if(String.valueOf(word).equals(endWord))
                           return level+1;
                        if(!wordList.contains(String.valueOf(word)))
                          {
                               continue;
                          }  
                        wordList.remove(String.valueOf(word));
                        q.add(String.valueOf(word));
                       // word = original;
                   }
                   word[j] = original;
               }
           }
           
       }
       return level;
   }
   
}
