public class MaximumBetAncestorchild {
    static class Node  
{ 
    int key; 
    Node left, right; 
   
    public Node(int key)  
    { 
        this.key = key; 
        left = right = null; 
    } 
} Node root;
    public static void main(String[] args)  
    { 
        MaximumBetAncestorchild tree = new MaximumBetAncestorchild(); 
   
        // Making above given diagram's binary tree 
        tree.root = new Node(8); 
        tree.root.left = new Node(3); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(6); 
        tree.root.left.right.left = new Node(4); 
        tree.root.left.right.right = new Node(7); 
   
        tree.root.right = new Node(10); 
        tree.root.right.right = new Node(14); 
        tree.root.right.right.left = new Node(13); 
   
        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.maxDiff(tree.root)); 
    }
    static class Res{
        int r = Integer.MIN_VALUE;

    } 
    private int maxDiff(MaximumBetAncestorchild.Node node) {
        Res res = new Res();

//int max = Integer.MIN_VALUE;
        maxDiffUtil(node, res);
        return res.r;
    }

    private int maxDiffUtil(MaximumBetAncestorchild.Node t, Res res) {

        if(t == null)
        return Integer.MAX_VALUE;

        if(t.left == null && t.right == null)
        return t.key;

        int val = Math.min(maxDiffUtil(t.left, res), maxDiffUtil(t.right, res));

        res.r = Math.max(res.r,t.key - val);

        return Math.min(val, t.key);

    }
}
