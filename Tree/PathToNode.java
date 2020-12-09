package Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PathToNode {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans  = new ArrayList<>();
        
        preorder(A, B , ans);
        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
        
        
        
    }
  
    public boolean preorder(TreeNode A, int target, ArrayList<Integer> ans)
    {
        if(A == null)
        return  false;
        ans.add(A.val);
        if(A.val == target)
        return true;
        
        if(preorder(A.left, target, ans) || preorder(A.right, target, ans) )
         return true;
         
         ans.remove(ans.size()-1);
         return false;
     
    }
public static void main(String[] args) {
    TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        PathToNode p = new PathToNode();
        p.solve(root, 4);


}
}
