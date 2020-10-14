package Tree;

public class DistanceBetTwoNodes {
    //ques : https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
    // use of LCA concept
    public static class Node {
        int value;
        Node left;
        Node right;
 
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                             + findDistance(root, 4, 5));
                              
        System.out.println("Dist(4, 6) = "
                             + findDistance(root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + findDistance(root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + findDistance(root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + findDistance(root, 8, 5));
    }

    private static int findDistance(Node root, int i, int j) {
       Node lca = lowestCommonAncestor(root,i,j);

       int d1 = findlevelDistance(lca,i,0);
       int d2 = findlevelDistance(lca,j,0);




        return d1+d2;
    }

    private static int findlevelDistance(Node root, int a, int level) {
        if(root == null)
        return -1;

        //preorder recursion 
        
        if(root.value == a)
        return level;

        int l = findlevelDistance(root.left, a, level+1);
        if(l == -1)
          return findlevelDistance(root.right, a, level+1);
       
          return l; 


    }

    private static Node lowestCommonAncestor(Node root, int i, int j) {
        if(root == null)
        return null;
        if(root.value == i || root.value == j)
        return root;
        //postorder recursion

        Node left = lowestCommonAncestor(root.left, i, j);
        Node right = lowestCommonAncestor(root.right, i, j);
        if(left != null && right != null)
           return root;
        if(left != null)
          return left;
        return right;     
    }
}
