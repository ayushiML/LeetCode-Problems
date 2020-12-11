package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleDirectedGraph {
     private final int v ;
     private final List<List<Integer>> adj;

     //dfs
     // bfs similar to kahn topological sort
     DetectCycleDirectedGraph(int V)
     {
         v =V;
         adj = new LinkedList<>();
         for(int i = 0 ; i < v ; i++)
         {
             adj.add(new LinkedList<>());

         }
     }
     public void addEdge(int source , int dest )
     {
         adj.get(source).add(dest);
     }
     public static void main(String[] args) {
         DetectCycleDirectedGraph d = new DetectCycleDirectedGraph(4);
        d.addEdge(0, 1); 
        d.addEdge(0, 2); 
        d.addEdge(1, 2); 
        d.addEdge(2, 0); 
        d.addEdge(2, 3); 
        d.addEdge(3, 3);
       System.out.println( d.isCyclic());
     }

     private boolean isCyclic() {
         boolean[] visited = new boolean[v];
         boolean[] recursion = new boolean[v];

         for(int i = 0 ; i < v; i++)
         {
             
               if(isCyclicUtil(visited, recursion, i))
                 return true;
                
         }
         return false;
        }
     

     private boolean isCyclicUtil(boolean[] visited, boolean[] recursion, int i) {

        if(recursion[i])
          return true;
        if(visited[i])
           return false;
        recursion[i] = true;
        visited[i] = true;
        Iterator<Integer>  e = adj.get(i).iterator();
        while(e.hasNext())
        {   Integer next = e.next();
            
               if(isCyclicUtil(visited, recursion, next))
                  return true;
        }    
         return false;
     }

}
