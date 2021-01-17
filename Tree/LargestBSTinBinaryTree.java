package Tree;

public class LargestBSTinBinaryTree {
    static class Info
    {
        int size;
        int lenMax;
        int min;
        int max;
        boolean isBST;

        public Info(int size, int lenMax, int min, int max, boolean isBST) {
            this.size = size;
            this.lenMax = lenMax;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
       
    }

    public  Info largestBst(Node node)
    {
        if(node == null)
           return new Info(0,0 , Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        if(node.left == null && node.right ==  null)
           return new Info(1 , 1 ,node.val, node.val , true);
           
        Info l = largestBst(node.left);
        Info r = largestBst(node.right);
        
        Info res = new Info(0,0 , Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        res.size = l.size+r.size+1;
        if(l.isBST &&  r.isBST && l.max < node.val && r.min > node.val)
        {
            res.min = Math.min(l.min , Math.min(r.min,node.val));
            res.max =  Math.max(r.max , Math.max(l.max,node.val));

            res.lenMax =res.size;
            res.isBST = true;
            return res;
        }
        res.lenMax = Math.max(l.lenMax, r.lenMax);
        res.isBST = false;
        return res;
    


    }
    Node root;
    public static void main(String[] args) {
        LargestBSTinBinaryTree tree = new LargestBSTinBinaryTree(); 
        tree.root = new Node(50); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(60); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(20); 
        tree.root.right.left = new Node(55); 
        tree.root.right.left.left = new Node(45); 
        tree.root.right.right = new Node(70); 
        tree.root.right.right.left = new Node(65); 
        tree.root.right.right.right = new Node(80); 
  
        /* The complete tree is not BST as 45 is in right subtree of 50. 
         The following subtree is the largest BST 
             60 
            /  \ 
          55    70 
          /     /  \ 
        45     65   80 
        */
        System.out.println("Size of largest BST is " + tree.largestBst(tree.root).lenMax); 
    }
}
