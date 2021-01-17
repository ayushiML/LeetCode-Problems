package Graph;
import java.util.*;
public class WordLadder {
    static class Node
    {
        String word;
        int distance;

        public Node(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
        
    }
    
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
          Map<String, List<String>> map = new HashMap<>();
          for(int i = 0 ;  i < beginWord.length(); i++)
          {
              String str = beginWord.substring(0, i) +"*"+beginWord.substring(i+1);
              if(!map.containsKey(str))
                 map.put(str, new LinkedList<>());
              map.get(str).add(beginWord);   

          }

          
          for(String word : wordList)
          {
            for(int i = 0 ;  i < word.length(); i++)
            {
                String str = word.substring(0, i) +"*"+word.substring(i+1);
                if(!map.containsKey(str))
                   map.put(str, new LinkedList<>());
                map.get(str).add(word);   
  
            }
          }

          Queue<Node>  q = new LinkedList<>();
          q.add(new Node(beginWord,1));
          Set<String> visited = new HashSet<>();
          visited.add(beginWord);
          while(!q.isEmpty())
          {
              Node curr = q.poll();
              String word = curr.word;
              int dist = curr.distance;

              if(word.equals(endWord))
                return dist;
                
           for(int i = 0 ; i < word.length(); i++)
           {
            String str = word.substring(0, i) +"*"+word.substring(i+1);
            List<String> l = map.get(str);
            for(String s : l)
            {
                if(!visited.contains(s))
                {
                    visited.add(s);
                    q.add(new Node(s,dist+1));
                }
            }
           }
          }
          return 0;
       }
          
       
    
}
