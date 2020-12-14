package LinkedList;

public class MergeTwoList {
    //https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head ;
        while(true)
        {
            if(l1 == null)
            {
                temp.next = l2;
                break;
            }
            else if( l2 == null)
            {
                temp.next = l1;
                break;
            }
            if(l1.val <= l2.val)
            {
                temp.next = l1;
                l1 = l1.next;
                
            }
            else if(l1.val > l2.val)
            {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
}
