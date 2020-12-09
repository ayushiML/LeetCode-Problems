import java.util.ArrayList;

public class ShortestPrefix {
   // https://www.interviewbit.com/problems/shortest-unique-prefix/
   // Trie data structure
   
    
        static  class TrieNode
        {
            int[] count = new int[26];
            TrieNode[] characters = new TrieNode[26];
            boolean isEndOfWord ;
            TrieNode()
            {
                for(int i = 0 ; i < 26 ; i++)
                {
                    count[i] = 0 ;
                    characters[i] =null;
                }
                isEndOfWord = false;
            }
            
        }
        public ArrayList<String> prefix(ArrayList<String> A) {

            ArrayList<String> result =new ArrayList<>();
            //construct trie
            TrieNode root = new TrieNode();
            for(String word : A)
            {
                insert(word, root);

            }
            // update result with find function  
            for(String word : A)
            {
                find( word,result, root);
            }

            return result;
        }

        private void find(String word,ArrayList<String> result, ShortestPrefix.TrieNode root) {
             String ans = "";
             TrieNode node = root;
             for(int i = 0 ; i  < word.length(); i++)
             {
                 int index = word.charAt(i)-'a';
                 if(node.count[index] == 1)
                 {    ans = ans + word.charAt(i);
                      result.add(ans);
                      return;
                 }
                 else{
                     ans = ans +word.charAt(i);
                     node = node.characters[index];
                 }
             }
             return;

		}

		private void insert(String word, ShortestPrefix.TrieNode root) {
            
            TrieNode  node = root;
            for(int  i = 0 ; i < word.length(); i ++)
            {   
                int index = word.charAt(i)-'a';
                if(node.characters[index] != null)
                { node.count[index] +=1;
                    node = node.characters[index];

                }
                else{
                    TrieNode newNode = new TrieNode();
                    newNode.isEndOfWord = false;
                    node.characters[index] = newNode;
                    node.count[index] += 1;
                    node = newNode;


                }


            }


        }
    
}
