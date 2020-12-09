package Stack;

import java.util.Stack;

public class NextGreaterNumber {
    static void printNGEOptimized(int arr[], int n)
    { 
        //variation 1: Next greater number to right 
        // j   : i+1 to n-1 break on arr[j]> arr[i]
        //answer : s.top(). if stack empty -1
        int[] arr1 = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n-1 ; i >-1 ; i--)
        {
            while(!s.isEmpty() && s.peek() <= arr[i])
            s.pop();

            if(s.isEmpty())
              arr1[i] = -1;
              else
              arr1[i] = s.peek();

              s.push(arr[i]);
        }
    } 
    
    
    // https://www.geeksforgeeks.org/next-greater-element/
    static void printNGE(int arr[], int n)  
    { 
        int i = 0; 
        Stack<Integer> s = new Stack<>();
        
        //s.top = -1; 
        int element, next; 
  
        /* push the first element to stack */
        s.push(arr[0]); 

       for( i = 1 ; i < n ; i++)
       {
           next = arr[i];

           while(!s.isEmpty())
           {
               element = s.pop();
               while(element < next)
               {
                   System.out.println(element + " " +next);
                   if(s.isEmpty()== true)
                     break;
                      element = s.pop();

               }
               if(element > next)
                s.push(element);
           }
           s.push(next);
       }
       while(!s.isEmpty())
       {
           System.out.println(s.pop() +" "+"-1");
       }
}}
