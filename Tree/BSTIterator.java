package Tree;

import java.util.Stack;

class BSTIterator {
// https://leetcode.com/problems/binary-search-tree-iterator/
// used stack 
// avg space O(h) solution


    Stack<TreeNode> s ;
     
     public BSTIterator(TreeNode root) {
         s = new Stack<>();
         TreeNode curr = root;
         while(curr != null)
         {
             s.push(curr);
             curr = curr.left;
         }
     }
 
     /** @return whether we have a next smallest number */
     public boolean hasNext() {
         if(!s.isEmpty())
            return true;
            
            return false;
            
     }
 
     /** @return the next smallest number */
     public int next() {
         
         TreeNode node = s.pop();
         TreeNode curr = node;
         if(curr.right != null)
         {   curr = curr.right;
             while(curr != null)
             {   s.push(curr);
                  curr = curr.left;
             }
         }
         
         
         
         
         return node.val;
     }
 }
