package Stack;

import java.util.Stack;

class MinStack {
    Stack<Integer> s ;
   long minElement = 0;
   /** initialize your data structure here. */
   public MinStack() {
       s = new Stack<>();
       minElement = Integer.MAX_VALUE;
       
   }
   
   public void push(int x) {
       if(s.isEmpty())
       { s.push(x);
         minElement = x;
        
       }
       else
       {
           if(x >= minElement)
           {
               s.push(x);
           }else
           {
               int y = 2*x -(int) minElement;
               s.push(y);
               minElement = x;
               
           }
       }
       
   }
   
   public void pop() {
       if(s.isEmpty())
       {   System.out.println(" empty stack");
           return;
       }else
       {
           int y = s.pop();
           if(y >= minElement)
                return;
           else
           {
               minElement = 2*minElement - y;
               
           }
       }
       
       
   }
   
   public int top() {
       
       if(s.peek() >= minElement)
       {
           return s.peek();
       }
       else
       {
          return (int)minElement;
       } 
   }
   
   public int getMin() {
      return(int) minElement; 
   }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/
