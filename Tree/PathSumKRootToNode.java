package Tree;
import java.util.*;

public class PathSumKRootToNode {
    //https://leetcode.com/problems/path-sum-ii/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        
        pathSumUtil(root, ans , sub, sum);

        return ans;
        
    }

    private void pathSumUtil(TreeNode node, List<List<Integer>> ans, List<Integer> sub, int sum) {
        if( node == null)
          return;

        sub.add(node.val);
        //sum = sum- node.val;

        if(node.left == null && node.right == null && sum == node.val )
        {
            ans.add(new ArrayList<Integer>(sub));
            
        }
        else
        {
            pathSumUtil(node.left, ans, sub, sum-node.val);
            pathSumUtil(node.right, ans, sub, sum-node.val);
        }
            
        sub.remove(sub.size()-1);
    }
    public static void main(String[] args) {
        
    }
}
