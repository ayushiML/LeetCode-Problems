package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Postorder {
    public List<Integer> traversal(TreeNode root)
    {
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        
        while(curr != null || !s.isEmpty())
        {
            if(curr != null)
            {
                s.push(curr);
                curr = curr.left;

            }
            else
            {
            TreeNode temp = s.peek().right;
            if(temp == null)
            {   temp = s.pop();
                l.add(temp.val);
                while(!s.isEmpty() && temp == s.peek().right)
                {
                    temp = s.pop();
                    l.add(temp.val);
                }

            }
            else
               curr =temp;
            } 
        }
        return l;
        
    }
}
