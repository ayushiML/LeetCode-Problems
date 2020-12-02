package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesAtDistanceK {
    Map<TreeNode , TreeNode> parent ;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // we  do dfs to annotate every node with information about it's parent 
        // after we do bfs to find all node at a distance of k 
        parent = new HashMap();
        dfs(root , null);
        // dfs done
        List<Integer> res = new LinkedList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        
        queue.add(target);
        set.add(target);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0 ; i < size; i++)
            { TreeNode node = queue.poll();
                if(K==0)
                    res.add(node.val);
             
             if(node.left != null && set.add(node.left))
                 queue.add(node.left);
             if(node.right != null && set.add(node.right))
                 queue.add(node.right);
             if(parent.get(node) != null && set.add(parent.get(node)))
                 queue.add(parent.get(node));
             
            }
            K--;
        }
        return res;
        
    }
    
    public void dfs (TreeNode node , TreeNode par)
    {
        if(node != null)
        {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
            
        }
    }
    public static void main(String[] args) {
        
    }
}
