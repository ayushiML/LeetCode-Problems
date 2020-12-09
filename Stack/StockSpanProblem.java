package Stack;

import java.util.Stack;

public class StockSpanProblem {
    //https://www.geeksforgeeks.org/the-stock-span-problem/
    public static void main(String[] args) 
    { 
        int price[] = { 10, 4, 5, 90, 120, 80 }; 
        int n = price.length; 
        int S[] = new int[n]; 
  
        // Fill the span values in array S[] 
        calculateSpan(price, n, S); 
  
        // print the calculated span values 
        printArray(S); 
    }

    private static void printArray(int[] s) {
        for(int i = 0 ; i < s.length; i++)
        {
            System.out.print(s[i] +" ");
        }
    }

    private static void calculateSpan(int[] price, int n, int[] s) {
        Stack<Integer> stack = new Stack<>();
        s[0] = 1;
        stack.push(0);
        for(int i = 1 ; i < n; i++)
        {
            while(!stack.isEmpty() && price[stack.peek()] <= price[i])
              stack.pop();

             if(stack.isEmpty())
               s[i] = i+1;
             else
               s[i] = i-stack.peek();  
               
               stack.push(i);

        }
    }
}
