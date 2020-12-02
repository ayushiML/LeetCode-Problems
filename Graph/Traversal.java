package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.synth.SynthStyle;

//import sun.awt.AWTAccessor.SystemTrayAccessor;

public class Traversal {
    // topological sort : A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
    private LinkedList<Integer> adj[];
    private int v;
    Traversal(int v)
    {
this.v = v;
adj = new LinkedList[v];
for(int i = 0 ; i < v ; i ++)
{
    adj[i] = new LinkedList<Integer>();
}
    }

    public static void main(String[] args) {
        Traversal g = new Traversal(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.topologicalSort();
    }

    private void topologicalSort() {
        boolean[] visited = new boolean[v];
    Stack<Integer> s = new Stack<>();
    for(int i = 0 ; i < v ; i++)
    {

    if(visited[v] != true)
    topologicalSortUtil(v,visited,s);
    }
    System.out.println("topological sort with dfs modication method");
    while(!s.isEmpty())
    {
        System.out.print(s.pop());
    }

}

    private void topologicalSortUtil(Integer vertex,boolean[] visited, Stack<Integer> s) {
        visited[vertex] = true;
        Iterator<Integer> i =  adj[vertex].iterator();
        while(i.hasNext())
        {   Integer node = i.next();
            if(visited[node] == false)
            topologicalSortUtil(node, visited, s);
        }
        s.push(vertex);
}

private void topologicalZerodegree()
{
    //find indegree
    int[] indegree = new int[v];
    for(int i = 0 ; i < v ; i++)
    {
       Iterator<Integer> it =  adj[i].iterator();
       while(it.hasNext())
       {
           indegree[it.next()]++;
       }
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0 ; i < v ; i++)
    {
       if( indegree[i] == 0)
       q.add(i); 
    }
    List<Integer> result = new LinkedList<>();
    int count_visited = 0 ; 

    while(!q.isEmpty())
    {
        Integer next = q.poll();
        result.add(next);
        Iterator<Integer> i = adj[next].iterator();
        while(i.hasNext())
        {   Integer e = i.next();
            if(--indegree[e] == 0)
            q.add(e);
        }





        count_visited++;

    }
    if(count_visited != v)
     {   System.out.println(" not possible , cycle exist");
         return;
}

//print list 
System.out.println(Arrays.toString(result.toArray()));

}
private void addEdge(int i, int j) {
        adj[i].add(j);
    }
    

}
