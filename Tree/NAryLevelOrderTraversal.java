// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3871/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // level order traversal is through queue 
        Queue<Node> q = new LinkedList<>();
        if(root != null)q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
             int size = q.size();
            while(size-- >0){
               Node x=  q.remove();
               level.add(x.val);
               q.addAll(x.children);
            }
            result.add(level);
        }
        return result;
    }
}
