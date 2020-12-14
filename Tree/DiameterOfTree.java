package Tree;

public class DiameterOfTree {
    class Res
    {
        int r = 0;
    }
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        
        Res res = new Res();
        diameterFind(root,res );
        
        return res.r;
        
    }
    
    int diameterFind(Node node , Res res)
    {
        if(node == null)
        return 0;
        
        
        int l = diameterFind(node.left ,  res);
        int r = diameterFind(node.right, res);
        
        int temp = 1 +Math.max(l, r);
        
        int ans = Math.max(temp, l+r+1);
        
        res.r = Math.max(res.r, ans);
        
        
        
        
         return temp;
        
        
    }
}
