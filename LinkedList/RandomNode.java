package LinkedList;

import java.util.Random;

//import jdk.javadoc.internal.doclets.formats.html.markup.Head;

public class RandomNode {
     int size = 0 ;
      ListNode h = null;
    public RandomNode(ListNode head) {
         ListNode temp = head;
         h = head;
         while(temp != null)
         {
             size++;
             temp = temp.next;

         }
    }
    
    //public static int count
    /** Returns a random node's value. */
    public int getRandom() {

  Random random = new Random();
  int r = random.nextInt(size)+1;
ListNode node = h;
while(node != null){
r--;
  if(r == 0 )
    return node.val;
  node = node.next;
    
}
return h.val;
//return node.val;
}
}
