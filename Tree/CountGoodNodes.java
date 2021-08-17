class Solution {
  //https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3899/
    static int goodCount ;
    public int goodNodes(TreeNode root) {
        // travering to every node and in the path , keep highest value
        goodCount =0;
        traversal(root.val , root);
        return goodCount;
    }
    public void traversal( int highestInPath , TreeNode node)
    {
        if(node == null)
            return ;
        
        if(node.val >= highestInPath){
            highestInPath = node.val;
            goodCount++;
        }
        traversal(highestInPath,node.left);
        traversal(highestInPath,node.right);
        
        
        
    }}
