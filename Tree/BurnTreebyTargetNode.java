package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BurnTreebyTargetNode {
    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        burnTree(root, 4);
    }

    static void burnTree(TreeNode root, int target)
    {
        Queue<TreeNode> q = new LinkedList<>();
        burnTreeUtil(root, target, q);


        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode temp = q.remove();
                System.out.print(temp.val);

                if(temp.left != null)
                  q.add(temp.left);
                if(temp.right != null)
                  q.add(temp.right);

            }
        }
        
    }

    private static int burnTreeUtil(TreeNode node, int target, Queue<TreeNode> q) {

        if(node == null)
           return 0;
        if( node.val == target)
           
        {
            System.out.println(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);


            return 1;
        }

        int a = burnTreeUtil(node.left, target, q);

        if(a== 1)
        {
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int i =0 ; i < size; i++)
                {   TreeNode temp = q.remove();
                    System.out.print(temp.val);

                    if(temp.left != null)
                      q.add(temp.left);
                    if(temp.right != null)
                      q.add(temp.right);

                }
                
            }
            if(node.right != null )
                q.add(node.right);
             System.out.println(node.val);
             return 1;    
        }
        int b = burnTreeUtil(node.right, target, q);

        if(b == 1)
        {
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int i =0 ; i < size; i++)
                {   TreeNode temp = q.remove();
                    System.out.print(temp.val);

                    if(temp.left != null)
                      q.add(temp.left);
                    if(temp.right != null)
                      q.add(temp.right);

                }
                
            }
            if(node.left != null )
                q.add(node.left);
             System.out.println(node.val);   
             return 1; 
        }
        return 0;
    }
}
