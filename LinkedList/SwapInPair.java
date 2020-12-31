package LinkedList;

public class SwapInPair {
    public ListNode swapPairs(ListNode head) {
        //https://leetcode.com/problems/swap-nodes-in-pairs/
        ListNode prev = null;
          if(head == null || head.next == null)
              return head;
          ListNode a = head;
          ListNode b = head.next;
          ListNode newhead = b;
          while(a != null && b != null)
          {
              a.next = b.next;
              b.next  = a;
              if(prev != null) prev.next =b;
              
              prev = a;
              if(a.next == null)  break;
              b = a.next.next;
              a = a.next;
              
          }
          
          return newhead;
          
      }
}
