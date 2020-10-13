package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ActivitySelection {
    //we always consider the next activity as minimum finishing time activity.
    //https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
    public static void main(String[] args) 
    { 
    int s[] =  {1, 3, 0, 5, 8, 5}; 
    int f[] =  {2, 4, 6, 7, 9, 9}; 
    int n = s.length; 
         
    printMaxActivities(s, f, n); 
    }
    static class Pair{
        int arr ;
        int depart ;
        Pair(int a, int d)
        {
            arr = a;
            depart = d ;
        }
    }
    static void printMaxActivities(int[] s, int[] f, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( n, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b)
            {
                return a.depart- b.depart;
            }
           });
          for(int i = 0; i < n ; i++)
          {   Pair p = new Pair(s[i],f[i]);
              pq.offer(p);
          }
          int start = pq.peek().arr;
          int end = pq.peek().depart;
          System.out.println(start + " "+ end);
          pq.poll();
          for(Pair x: pq)
          {    
              if(end <= x.arr)
              {
                  start = x.arr;
                  end = x.depart;
                  System.out.println(start + " "+ end);
              }
          }

    }
}