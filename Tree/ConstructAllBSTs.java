package Tree;
import java.util.*;
public class ConstructAllBSTs {
    public List<TreeNode> generateTrees(int n) {
        if(n ==0 )
           return new ArrayList<>();
        return constructTree( 1 , n);
        
    }
    public List<TreeNode> constructTree(int start , int end)
    {
        List<TreeNode> list = new ArrayList<>();
        
        if(start > end)
        {
            list.add(null);
                return list;
        }
        for(int  i = start ; i <= end; i++)
        {
            List<TreeNode> left = constructTree(start, i-1);
            List<TreeNode> right = constructTree(i+1, end);
            
            for(int j = 0 ;  j < left.size(); j++)
            {
                TreeNode leftNode = left.get(j);
                for(int k = 0 ; k < right.size(); k++)
                {
                    TreeNode rightNode = right.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
