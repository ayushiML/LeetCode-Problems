import java.util.PriorityQueue;

public class MedianInStream {
    
        PriorityQueue<Integer> minheap ;
         PriorityQueue<Integer> maxheap;
         /** initialize your data structure here. */
         public MedianInStream() {
             minheap = new PriorityQueue<>((a,b)->a-b);
             maxheap = new PriorityQueue<>((a,b)-> b-a);
             
            }
         
            public static void main(String[] args) {
             MedianInStream obj = new MedianInStream();
             obj.addNum(2); 
             obj.findMedian();  
            }
         public void addNum(int num) {
             if(maxheap.isEmpty() || maxheap.peek() >= num)
             {maxheap.add(num);}
             else
             minheap.add(num);
             int min = minheap.size();
             int max = maxheap.size();
             if( min + 1 < max)
               minheap.add(maxheap.poll());
             else if(min > max)
              maxheap.add(minheap.poll());
              return;  
             
             
         }
         
         public double findMedian() {
            int min = minheap.size();
            int max = maxheap.size();
            if(min == 0)
            return maxheap.peek();
            int n = minheap.peek();
            int m = maxheap.peek();
            if( min == max)
            return (double)n+m/2;

            else
            return m;

         }
     
}
