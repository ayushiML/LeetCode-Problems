package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicateSubTree {
    static Map<String, Integer> map;
    static List<TreeNode> list;
    static class TreeNode {
        int val;
          TreeNode left;
         TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new LinkedList<>();
        duplicate(root);
        return list;

    }

    public static String duplicate(TreeNode node) {
        if (node == null)
            return "X";

        String l = duplicate(node.left);
        String h = duplicate(node.right);

        String s = Integer.toString(node.val) + "-" + l + "-" + h;

        map.put(s, map.getOrDefault(s, 0) + 1);

        if (map.get(s) == 2)
            list.add(node);
        return s;

    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        findDuplicateSubtrees(root);
    }
    
}
