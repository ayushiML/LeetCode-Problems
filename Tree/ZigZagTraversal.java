package Tree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);  
    root.left = new Node(20);  
    root.right = new Node(30);  
    root.left.left = new Node(40);  
    root.left.right = new Node(60);
    printZigZag(root);
    }
    public static void printZigZag(Node root)
    {
        
      Deque<Node> dq = new LinkedList<>();
      boolean dir = false;
      // 0 for right to left and insert at first 
      dq.addLast(root);
      while(!dq.isEmpty())
      {
          int size = dq.size();
          for(int i = 0 ; i < size; i++)
          {
              if(!dir)
              {
                  Node temp = dq.pollLast();
                  if(temp.right != null)
                   {
                     dq.offerFirst(temp.right);
                   }
                   if(temp.left != null)
                   {
                       dq.offerFirst(temp.left);
                    
                   }
                   System.out.print(temp.val +" ");
              }
              else
              {
                Node temp = dq.pollFirst();
                
                 if(temp.left != null)
                 {
                     dq.offerLast(temp.left);
                  
                 }
                 if(temp.right != null)
                 {
                   dq.offerLast(temp.right);
                 }
                 System.out.print(temp.val +" ");
              }


          }
          System.out.println();
          dir = !dir;
      }




    }
}
