package Tree;

public class Cousins {
    static void printCousins(Node root, Node node)  
{  
    // Get level of given node  
    int level = getLevel(root, node, 1);  
  
    // Print nodes of given level.  
    printGivenLevel(root, node, level);  
}

private static int getLevel(Node root, Node node, int level) {
    if (root == null)  
        return 0;  
    if (root == node)  
        return level;  
  
    // If node is present in left subtree  
    int downlevel = getLevel(root.left, node, level+1);  
    if (downlevel != 0)  
        return downlevel;  
  
    // If node is not present in left subtree  
    return getLevel(root.right, node, level+1);
}

private static void printGivenLevel(Node root, Node node, int level) {
if( level < 2 )
 return;
 else if(level == 2)
 {
     if(root.left == node || root.right == node)
       return;
       if(root.left != null)
        System.out.println(root.left.val);
        if(root.right != null)
        System.out.println(root.right.val);

 }
 if( level > 2)
 printGivenLevel(root.left, node, level-1);
 printGivenLevel(root.right, node, level-1);

}
}
