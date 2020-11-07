package Tree;

public class CheckBalanced {

    static boolean result = true;
    public static boolean isBalanced(Node root) {

        utilFunction(root);
        return result;
    }

    public static int utilFunction(Node node) {
        if (node == null)
            return 0;

        int l = utilFunction(node.left);
        int r = utilFunction(node.right);
        if (Math.abs(l - r) > 1)
            result = false;

        return 1 + Math.max(l, r);
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
        System.out.println(isBalanced(root));

    }

}
