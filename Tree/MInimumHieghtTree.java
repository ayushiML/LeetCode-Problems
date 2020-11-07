package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class MInimumHieghtTree {
    
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new LinkedList<>();
            if(n == 0)
                return ans;
            if(n == 1)
            {
                ans.add(0);
                return ans;
            }
            
            int[] degrees = new int[n];
            List<List<Integer>> adj = new ArrayList<>();
            for(int i  = 0 ; i < n ; i++)
            {
                adj.add(new ArrayList<Integer>());
            }
            for(int[] e : edges)
            {
                degrees[e[0]]++;
                degrees[e[1]]++;
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }
            Queue<Integer> q = new LinkedList<>();
            
            for(int i = 0 ; i <n ; i++)
            {
                if(degrees[i] == 1)
                    q.add(i);
            }
            while( n > 2)
            {
                int size = q.size();
                n = size;
                
                while(size > 0)
                {
                    int t = q.poll();
                    for(Integer i : adj.get(t))
                    {
                        degrees[i] --;
                        if(degrees[i] == 1)
                            q.add(i);
                    }
                }
                
                
                
                
            }
            for(int i = 0 ; i < q.size(); i++)
                {
                    ans.add(q.poll());
                }
                return ans;
           
        }
    
}
