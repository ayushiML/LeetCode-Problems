package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointer {
    static class Node{
    Node left;
    Node right;
    Node next;
    }
    public Node populateWithoutExtraspace(Node root)
    {

         if(root == null)
         return null;
         if(root.next != null)
          populateWithoutExtraspace(root.next);
          if(root.left != null)
            {
                if(root.right != null)
                {
                    root.left.next = root.right;
                    root.right.next = getNextNode(root);
                }
                else 
                    root.left.next = getNextNode(root);
                    populateWithoutExtraspace(root.left);
            }
            else if(root.right != null)
            {
                root.right.next = getNextNode(root);
                populateWithoutExtraspace(root.right);

            }
            else
            populateWithoutExtraspace(root.next);


        return root;
    }
    
    private Node getNextNode(Node root) {
        if(root == null)
        return null;

        Node temp = root.next;
        while(temp != null)
        {
            if(temp.left != null)
            return temp.left;
            if(temp.right!= null)
            return temp.right;

            temp = temp.next;
        }
        return null;
    }

    public Node populatewithextraspace(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        if(root == null)
        return null;
        q.add(root);Node temp = null;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int  i = 0 ; i < size; i++)
            {
                Node prev = temp;
                temp = q.poll();
                if(i >0)
                prev.next = temp;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);


            }
            temp.next = null;
        }
        return root;

    }
}
