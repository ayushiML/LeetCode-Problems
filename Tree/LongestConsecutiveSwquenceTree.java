package Tree;

public class LongestConsecutiveSwquenceTree {
   // https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/

   private static int val;

static class Result
   {
       int res;
   }

   static int longestConsecutive(Node root)
   {
      Result res = new Result();

      val = root.val;
    longestConsecutiveUtil(root, 0 , val, res);
      return res.res;
   }

   private static void longestConsecutiveUtil(Node root, int curr, int expected, Result res) {

    if(root == null)
     return ;
     if(root.val == expected)
      curr++;
      else
        curr = 1;
         res.res = Math.max(res.res, curr);
     longestConsecutiveUtil(root.left, curr, root.val+1, res);
     longestConsecutiveUtil(root.right, curr, root.val+1, res);
   }
}
