package LinkedList;

public class NthNodeFromEnd {
    ListNode head ;
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        ListNode new_node = new ListNode(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    }
    public static void main(String[] args) 
    { 
        NthNodeFromEnd llist = new NthNodeFromEnd(); 
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(35); 
  
        System.out.print(llist.printNthFromLast(3).val); 
    }

    private ListNode printNthFromLast(int n) {
        ListNode ref = head;
        ListNode main = head ;

        if(head == null || ( head.next == null && n == 1))
           return head;

        int count = 0;
        while( count < n )
        {
            if(ref == null)
            return null;
            ref = ref.next;
            count ++;

        }   
        if(ref != null)
        {
            if(head.next != null)
            return head.next;
        }
        
        
            while(ref != null)
            {
                main = main.next;
                ref = ref.next;
            }
            return main;
        
      

    }
}
