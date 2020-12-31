package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenTreeinLevelOrder {
    static class node  
{ 
    int data; 
    node left; 
    node right; 
    node(int data) 
    { 
        this.data = data; 
        left = null; 
        right = null; 
    } 
};
    static void print(node parent) 
{ 
    node curr = parent; 
    while (curr != null) 
    { 
        System.out.print(curr.data + " "); 
        curr = curr.right; 
    } 
}
static void flatten(node parent) 
{
    if(parent == null)
    return;

    Queue<node> q = new LinkedList<>();
    if(parent.left != null)q.add(parent.left);
    if(parent.right != null)q.add(parent.right);
    node prev = parent;
    while(!q.isEmpty())
    {
        int size = q.size();
        for(int i = 0 ; i < size; i++)
        {
            node curr = q.poll();
            prev.right= curr;
            prev.left = null;
            prev = curr;
            if(curr.left != null)q.add(curr.left);
            if(curr.right != null)q.add(curr.right);


        }

    }
    prev.left = null;
    prev.right =null;


}
public static void main(String[] args) {
    node root = new node(1); 
    root.left = new node(5); 
    root.right = new node(2); 
    root.left.left = new node(6); 
    root.left.right = new node(4); 
    root.right.left = new node(9); 
    root.right.right = new node(3); 
  
    // Calling required functions 
    flatten(root); 
    print(root); 
}

}
