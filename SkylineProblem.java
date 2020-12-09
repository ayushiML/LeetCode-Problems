import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;

public class SkylineProblem {
    public static void main(String[] args) {
        
    }
    public java.util.List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new LinkedList<>();
        List<int[]> heights = new ArrayList<>();
        
        for(int[] b : buildings)
        {
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1],b[2]});
            
        }
        Collections.sort(heights, (a, b)-> {
            if(a[0] != b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        
        Queue<Integer> p = new PriorityQueue<>((a,b)-> b-a);
        int prev = 0 ;
        p.offer(0);
        for(int[] h : heights)
        {
            if(h[1] < 0)
                p.offer(-h[1]);
            else
                p.remove(h[1]);
            int curr = p.peek();
            if(curr != prev)
            {  
                result.add(Arrays.asList(h[0], curr));
                prev = curr;
            }
        }return result;
        
        
        
    }
}
