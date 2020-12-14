package Tree;

public class SumOfpathNodeToNode {
    class Res
    {
        int value;
    }
    
    public int maxPathSum(TreeNode root) {
        Res res = new Res();
        res.value = Integer.MIN_VALUE;
        maxPath(root, res);
        
        return res.value;
    }
    public int maxPath(TreeNode node, Res res)
    {
        //bottom up 
        
        if(node == null)
            return 0;
        
        int l = maxPath(node.left, res);
        int r = maxPath(node.right,res);
        System.out.println(node.val+ " " +l +" "+r);
        int max_single = Math.max(Math.max(l,r)+node.val,node.val);
        int max_full = Math.max(max_single,l+r+node.val);
        System.out.println(node.val+ " " +res.value);
        res.value = Math.max(res.value,max_full);
        System.out.println(node.val+ " " +res.value);
        return max_single;
        
        
        
        
        
    }
}
