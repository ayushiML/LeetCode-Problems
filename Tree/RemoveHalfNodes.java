package Tree;

public class RemoveHalfNodes {
    public TreeNode solve(TreeNode A) {
        //https://www.interviewbit.com/problems/remove-half-nodes/
    
        // postorder 
        // leaves to root 
        if( A == null)
         return A;
         
         A.left = solve(A.left);
         A.right = solve(A.right);
         if( A.left == null && A.right == null)
         return A;
         
         if(A.left == null || A.right == null)
         {
             if( A.left != null)
               return A.left;
               else 
               return A.right;
         }
        return A;
    }
}
