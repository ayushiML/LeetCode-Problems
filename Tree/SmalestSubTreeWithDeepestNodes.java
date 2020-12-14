package Tree;
public class SmalestSubTreeWithDeepestNodes
{
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
          
        if( root == null)
            return null;
        
        int leftTree = depth(root.left);
        int rightTree = depth(root.right);
            
        
        if(leftTree == rightTree)
            return root;
        else if(leftTree > rightTree)
            return subtreeWithAllDeepest(root.left);
        else
            return subtreeWithAllDeepest(root.right);
            
        
        
    }
    
    public int depth(TreeNode node)
    {
        if(node == null)
            return 0;
        
        
        return 1 +Math.max(depth(node.left), depth(node.right));
    }
}