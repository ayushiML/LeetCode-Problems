package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    
        public List<Integer> preorderTraversal(TreeNode root) {
      
            Stack<TreeNode> s = new Stack<>();
            
            List<Integer> l = new ArrayList<>();
                if(root == null )
              return l;
            TreeNode curr = root;
            while(curr != null || !s.isEmpty())
            {
              
                while(curr != null)
                {
                    l.add(curr.val);
                    if(curr.right != null)
                        s.push(curr.right);
                    curr = curr.left;
                    
                }
                if(!s.isEmpty())
                curr = s.pop();
                
                
           }
            return l;
    }}

