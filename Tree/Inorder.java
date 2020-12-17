package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        
        while(curr != null || !s.isEmpty())
        {
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            l.add(curr.val);
            
            curr = curr.right;
            
            
            
        }
        return l;
        
    }
}
