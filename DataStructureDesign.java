
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


import java.util.ArrayDeque;


public class DataStructureDesign {
    //https://www.geeksforgeeks.org/design-a-queue-data-structure-to-get-minimum-or-maximum-in-o1-time/?ref=rp

    //design Queue which give min elemrnt at constant time
    public static void main(String[] args) {
         DataStructureDesign obj = new DataStructureDesign();
         obj.enqueue(6);
         obj.enqueue(7);
         obj.enqueue(2);
         obj.enqueue(9);
         System.out.println(obj.getMin());
         obj.dequeue();
         System.out.println(obj.getMin());
        



    }
    Queue<Integer> q;
    Deque<Integer> dq;
    DataStructureDesign()
    {
        q = new LinkedList<Integer>();
        dq = new ArrayDeque<Integer>();
    }
    public void enqueue(int num)
    {
            if(q.isEmpty())
            {
                q.add(num);
                dq.offerLast(num);
            }
            else{
                q.add(num);
                while(!dq.isEmpty()&& dq.peekLast() > num )
                {
                    dq.pollLast();

                }
                dq.offerLast(num);
            }
    }

    public void dequeue()
    {
        if(q.isEmpty())
        System.out.println("No element to remove");

        if(q.peek() != dq.peekFirst())
        {
            q.poll();

        }
        else{
            q.poll();
            dq.pollFirst();
        }

    }
    public int getMin()
    {
        return dq.peekFirst();
    }

}
