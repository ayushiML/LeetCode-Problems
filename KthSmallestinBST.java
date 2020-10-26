import java.util.Stack;

public class KthSmallestinBST {
    static class Node {
        int val;
          Node left;
         Node right;
          Node() {}
         Node(int val) { this.val = val; }
          Node(int val, Node left, Node right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public static int KthSmallestElement(Node root, int K) {
        // inorder iterative
        // left root right
        if (root == null)
            return -1;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        // s.add(root);
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.add(curr);
                curr = curr.left;
            }

            K--;
            curr = s.pop();
            if (K == 0)
                break;
            curr = curr.right;

        }
        if (curr != null)
            return curr.val;
        return -1;

    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        System.out.println(KthSmallestElement(root, 3));
    }
}
