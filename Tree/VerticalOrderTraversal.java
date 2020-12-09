package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
         TreeMap<Integer, List<Integer> > tree = new TreeMap<>();
         verticalTraversalUtil(root, 0 , tree);

         List<List<Integer>> ans = new LinkedList<>();
         for(Entry<Integer, List<Integer>> entry : tree.entrySet())
         {
             ans.add(entry.getValue());
         }
         return ans;
       }

       private void verticalTraversalUtil(TreeNode root, int i, TreeMap<Integer, List<Integer>> tree) {
        if( root == null)
        return ;

        List<Integer> list = tree.get(i);
        if(list == null)
        {
           list = new LinkedList<>();
           list.add(root.val);
        }
        else{
list.add(root.val);
        }
        tree.put(i, list);
        verticalTraversalUtil(root.left, i-1, tree);
        verticalTraversalUtil(root.right, i+1, tree);
        return;
    }
}
