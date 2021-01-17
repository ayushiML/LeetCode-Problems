package Arrays;

import java.util.*;

public class TopKFrequentElement {
    //https://leetcode.com/problems/top-k-frequent-elements/submissions/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            map.put(i , map.getOrDefault(i , 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : b.getValue().compareTo(a.getValue()));
        int[] ans = new int[k];
        
        for(Map.Entry<Integer, Integer> m : map.entrySet())
        {
            pq.offer(m);
        }
        for(int i =0 ; i  < k ; i++)
        {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
