package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorrisTraversal {
    //morris help to get back to root as stack does the operatio
    // inorder predecessor nee dto find
    // if cuur->left is not null then curr inorderprecessor ->right = current so that we can come back to curr after 
    //visiting left 
    public static void main(String[] args) {
        Node root = null;


        //
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        List<Integer> ans = new ArrayList<>();
        morrisTraversal(ans,root, 3);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private static void morrisTraversal(List<Integer> ans,Node root, int i) {
           if(root == null)
           return;
           Node pre = null;
           Node curr = root;
           while(curr != null)
           {
               if(curr.left == null)
               {
                   ans.add(curr.val);
                   curr = curr.right;
                   

               }
               else
               {
                   // if not null then curr's inorderPredesccor ->right = current
                   pre = curr.left;
                   while(pre.right != null && pre.right != curr)
                   pre = pre.right;
                   if(pre.right == null)
                   {
                       pre.right = curr;
                       curr = curr.left;
                   }
                   else{
                       //condition when pre.right == current condition is true , so need to revert changes
                       pre.right = null;
                       ans.add(curr.val);
                       curr = curr.right;

                   }

                 

               }
           }


    }
}
