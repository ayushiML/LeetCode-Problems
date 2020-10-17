package Tree;
import java.util.LinkedList;
import java.util.Queue;


public class SerializeDeserialize {
    public String serialize(TreeNode root) {
        StringBuffer sb = new  StringBuffer("");
        serializeHelper(root,sb);
        String str = sb.toString();
       // System.out.println(str);
        str = str.substring(0,str.length()-1);
        //System.out.println(str);
        return str;
        
        
        
    }
    public void serializeHelper(TreeNode node, StringBuffer sb)
    {
        if(node == null)
        {  sb.append("null").append(",");
         return ;
        }
        sb.append(Integer.toString(node.val)).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
        
        return ;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        String[] str = data.split(",");
        for(String s : str)
        {  // System.out.println(s);
            q.add(s);
        }
        return helper(q);
    }
    public TreeNode helper(Queue<String> q)
    {
        if(q.isEmpty())
            return null;
        String s = q.poll();
        System.out.println(s);
        if (s.equals("null")) 
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = helper(q);
        node.right = helper(q);
        return node;
        
        
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
        
    }
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
}
