package Tree;

import java.util.Arrays;

public class RecoverTree {
   //https://www.interviewbit.com/problems/recover-binary-search-tree/
//
public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
        root.left = new TreeNode(10); 
        root.right = new TreeNode(2); 
        root.left.left = new TreeNode(1); 
        root.left.right = new TreeNode(3); 
        root.right.right = new TreeNode(12); 
        root.right.left = new TreeNode(7);
     RecoverTree r = new RecoverTree();

        int[] ans = r.recoverTree(root);
        System.out.println(Arrays.toString(ans));

} 
TreeNode prev , first , middle , last ;
public int[] recoverTree(TreeNode A) {
prev = first = middle = last  = null;
modify_inorder(A);
if(first != null && last != null)
{
    return new int[]{
        last.val,first.val
    };
}
else if(first != null && middle != null)
     {return new int[]{ middle.val,first.val};}
     return new int[]{-1,-1};
     
     
    
}
public void modify_inorder(TreeNode node)
{
    if(node == null)
    return ;
    
    modify_inorder(node.left);
    if(prev != null && prev.val > node.val)

    {
        if(first == null)
        {
            first = prev;
            middle = node;
        }
        else
          last = node;
    }
    prev = node;
    modify_inorder(node.right);
    
}
}
    

