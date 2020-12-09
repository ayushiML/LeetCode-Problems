package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // left[] : nearest smaller to left
       // right[] : nearest samller to right
       // width[] : right - left- 1
       // Math.max(width*i : area)
       int n = heights.length;
       if(n == 0 )
           return 0;
       
       int[] left = new int[n];
       left[0] = -1;
       Stack<Integer> s = new Stack<>();
       s.push(0);
       for(int i = 1 ; i < n ; i++)
       {
           while(!s.isEmpty() && heights[i] <= heights[s.peek()])
               s.pop();
           
           left[i]  = (s.isEmpty())? -1:s.peek();
           s.push(i);
       }
       printArray(left);
       int[] right = new int[n];
       right[n-1] = n;
       s.clear();
       s.push(n-1);
       for(int i= n-2 ; i >=0 ; i--)
       {
           while(!s.isEmpty() && heights[i] <= heights[s.peek()])
               s.pop();
           
           right[i]  = (s.isEmpty())? n:s.peek();
           s.push(i);
       }
       printArray(right);
       int[] width = new int[n];
       int max_area = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++)
        {
            width[i] = right[i] - left[i] -1;
            max_area = Math.max(width[i] *heights[i], max_area);
        }
       return max_area;
       
       
   }
   private  void printArray(int[] s) {
       for(int i = 0 ; i < s.length; i++)
       {
           System.out.print(s[i] +" ");
       }
        System.out.println();
   }
   public static void main(String[] args) {
       
    LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
    int[] heights = {2, 3, 5, 6, 1};
       int x = largestRectangleInHistogram.largestRectangleArea(heights);
       System.out.println("ans :"+x);
   }
}
