package Graph;
import java.util.*;
public class CoursesScudeule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0 ; i < numCourses ; i++)
        {
            graph[i] = new LinkedList<>();
            
        }
        int[] indegrees = new int[numCourses];
        
        for(int[] p : prerequisites)
        {
            graph[p[1]].add(p[0]);
            indegrees[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        boolean flag = false;
        for(int i = 0; i < numCourses ; i++)
        {
            if(indegrees[i] == 0)
            {
                flag = true;
                q.add(i);
            }
        }
        if(!flag)
            return new int[]{};
        int count = 0;
        while(!q.isEmpty())
        {
            int temp = q.poll();
            ans.add(temp);
            List<Integer> list = graph[temp];
            for(int i : list)
            {
                if(indegrees[i]-- == 0)
                    q.add(i);
                
            }
            count++;
        }
        int[] array = ans.stream().mapToInt(i->i).toArray();
        if( count == numCourses)
            return array;
        return new int[]{};
        
        
    } 
}
