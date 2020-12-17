package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class N_aryPreorder {
    static class Node 
{
    char key;
    ArrayList<Node> child;
 
    public Node(char key)
    {
        this.key = key;
        child = new ArrayList<>();
    }
}

public static void traversal(Node root)
{
    Stack<Node> s = new Stack<>();
    Node curr =root;
    s.push(curr);
    while(!s.isEmpty())
    {   curr = s.pop();

        if(curr != null)
        {
            // print curr
            System.out.print(curr.key+" ");
            for(int i = curr.child.size()-1; i >= 0 ; i-- )
                s.push(curr.child.get(i));
        }

    }    
    
}
public static void main(String[] args) {
    Node root = new Node('A');
    (root.child).add(new Node('B'));
    (root.child).add(new Node('F'));
    (root.child).add(new Node('D'));
    (root.child).add(new Node('E'));
    (root.child.get(0).child).add(new Node('K'));
    (root.child.get(0).child).add(new Node('J'));
    (root.child.get(2).child).add(new Node('G'));
    (root.child.get(3).child).add(new Node('C'));
    (root.child.get(3).child).add(new Node('H'));
    (root.child.get(3).child).add(new Node('I'));
    (root.child.get(0).child.get(0).child).add(new Node('N'));
    (root.child.get(0).child.get(0).child).add(new Node('M'));
    (root.child.get(3).child.get(0).child).add(new Node('O'));
    (root.child.get(3).child.get(2).child).add(new Node('L'));

    traversal(root);
}

}
