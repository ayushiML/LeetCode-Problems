package Tree;

public class MergeTwoTree {
//https://www.interviewbit.com/problems/merge-two-binary-tree/

   public TreeNode preorder(TreeNode r1 ,TreeNode r2 )
   {
       if(r1 == null && r2 == null)
       return r1;
       if(r1 == null)
          return r2;
          if(r2 == null)
          return r1;

          r1.val = r1.val+r2.val;


         r1.left =  preorder(r1.left, r2.left);
         r1.right = preorder(r1.right, r2.right);

         return r1;

   }
}
