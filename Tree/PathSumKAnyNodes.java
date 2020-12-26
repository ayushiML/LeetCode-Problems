package Tree;

import java.util.Vector;

public class PathSumKAnyNodes {
    static Vector<Integer> path = new Vector<>();

    public static void kAllPaths(int k , Node node)
    {
        if(node == null)
          return;
        path.add(node.val);
        
        kAllPaths(k, node.left);
        kAllPaths(k, node.right);
        int f = 0 ;
         // check if there's any k sum path that  
    // terminates at this node  
    // Traverse the entire path as  
    // there can be negative elements too
        for(int j = path.size()-1; j >= 0 ; j--)
        {
            f+= path.get(j);
            if(f == k)  
               printPath(j);
        }
        path.remove(path.size()-1);
    }

    private static void printPath(int j ) {
        for(int i = j ; i < path.size(); i++)
          System.out.print(path.get(i)+" ");
          System.out.println();  
    }
    public static void main(String[] args) {
        Node root = new Node(1);  
    root.left = new Node(3);  
    root.left.left = new Node(2);  
    root.left.right = new Node(1);  
    root.left.right.left = new Node(1);  
    root.right = new Node(-1);  
    root.right.left = new Node(4);  
    root.right.left.left = new Node(1);  
    root.right.left.right = new Node(2);  
    root.right.right = new Node(5);  
    root.right.right.right = new Node(2); 
    kAllPaths(5, root);
    }
}
