package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NmeetingRoom {
    class Pair{
        int time ; int arrival;
        Pair(int t, int a)
        {
            time = t ;
            arrival = a ;
        }
    }
    //https://www.interviewbit.com/problems/meeting-rooms/
    public static int solve(int[][] A) {
        int n = A.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>( n*2+1, new Comparator<Pair>(){
         @Override
         public int compare(Pair a, Pair b)
         {
             if(a.time != b.time)
             return a.time - b.time;
             else
             return b.arrival -a.arrival;
         }
        });
        for(int[] x : A)
        {
            pq.offer(new NmeetingRoom().new Pair(x[0],1));
            pq.offer(new NmeetingRoom().new Pair(x[1],0));
            
        }
        int max = 0;
        int temp = 0;
        for(Pair p : pq)
        {   System.out.println(p.arrival +" "+p.arrival);
            if(p.arrival == 1)
            {   temp++;
                if(temp> max) max = temp;
            }
            else
             temp--;
             
        }
        return max;
       // Collections.sort()
    }
   public static void main(String[] args) {

        int[][] A = {{1, 18},
        {18, 23},{15, 29},
        {4, 15},
        {2, 11},
        {5, 13}
   };
        System.out.println(solve(A));
    }
}