package LinkedList;

public class ReverseList {
    public ListNode reverese(ListNode head)
    {
        ListNode next = null;
        ListNode prev  =null;
        ListNode curr = head;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        } 
        return prev;
    }
    // recursive linkedlist
    public ListNode revereseRecursive(ListNode head)
    {
        if(head == null || head.next == null)
          return head;

        ListNode newNode = revereseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

}
