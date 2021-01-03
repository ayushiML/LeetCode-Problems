class Trie {

    public Trie() {
        root = new TrieNode();
    }
    /** Initialize your data structure here. */
 class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
       TrieNode()
       {
          
         isLeaf = false;
           for (int i = 0 ; i <26; i++)
               children[i] = null;
           
       }
    }
    static TrieNode root;
    /** Inserts a word into the trie. */
    public void insert(String s) {
       // Trie root = new Trie;
        int len = s.length();
        TrieNode curr = root;
        int index = -1;
        for(int i = 0; i <len ;i++)
        {
            index = s.charAt(i)-'a';
            if(curr.children[index]== null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            
        }
        curr.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        TrieNode curr = root;
        int index =-1;
        
        for(int i = 0; i <len ;i++)
        {
            index = word.charAt(i)-'a';
            if(curr.children[index]== null)
            {
                return false;
            }
            curr = curr.children[index];
            
        }
        if(curr.isLeaf == true && curr != null)
            return true;
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        
       int len = word.length();
        TrieNode curr = root;
        int index =-1;
        
        for(int i = 0; i <len ;i++)
        {
            index = word.charAt(i)-'a';
            if(curr.children[index]== null)
            {
                return false;
            }
            curr = curr.children[index];
            
        }
        if( curr != null)
            return true;
        
        return false;  
        
        
        
    }
}