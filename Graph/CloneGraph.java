package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    //https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3501/
    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneGraph(Node node) {
        // bfs
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node temp = q.poll();

            Node clone = map.get(temp);
            if (temp.neighbors != null) {

                List<Node> l = temp.neighbors;
                Iterator<Node> i = l.iterator();
                while (i.hasNext()) {
                    Node next = (Node) i.next();
                    Node graphclone = map.get(next);
                    if (graphclone == null) {
                        q.add(next);
                        graphclone = new Node(next.val);
                        map.put(next, graphclone);
                    }
                    clone.neighbors.add(graphclone);
                }
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node n = new Node(2);
        cloneGraph(n);
        
    }
}
