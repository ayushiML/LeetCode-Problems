package LinkedList;

public class ReverseListinK {
    
    public static ListNode reverse(ListNode head, int k)
    {          //https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
               if(head == null)
                 return null;


                 int count = 0 ;
                 ListNode next = null;
                 ListNode prev  =null;
                 ListNode curr = head;
                 while(count < k && curr != null)
                 {
                     next = curr.next;
                     curr.next = prev;
                     prev = curr;
                     curr = next ;
                     count++;
                 }
                 if(next != null)
                    head.next = reverse(next, k);
                 
                 return prev;   




    }
}
