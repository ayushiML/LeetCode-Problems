package Graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleUndirected {
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        int V = 3;
        ArrayList<ArrayList<Integer>>  g = new ArrayList<>();
        g.add(0,new ArrayList<>());
        g.add(1,new ArrayList<>());
        g.add(2,new ArrayList<>());

        g.get(0).add(1);
        g.get(0).add(2);
        g.get(1).add(2);
        g.get(2).add(0);
        g.get(2).add(1);

        if (isCyclic(g,V)) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
  
       
    } 

    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {  
       // add your code here
       boolean[] visited= new boolean[V];
       for(int i = 0 ; i <V ; i++)
       {
           if(visited[i] == false)
             if(dfs(visited, g,V, i , -1))
             return true;
       }
       return false;
       
    }
    static boolean dfs(boolean[] visited,ArrayList<ArrayList<Integer>> g,int V , int point, int parent)
    {
        visited[point] = true;
        
        ArrayList<Integer> l = g.get(point);
        Integer x;
        Iterator<Integer> i = l.iterator();
        while(i.hasNext())
        {
            x = (int)i.next();
            if(!visited[x])
            {
                if(dfs(visited,g,V,x,point))
                return true;
            }
            else if(parent != x)
            return true;
        }
        return false;
    }
}
