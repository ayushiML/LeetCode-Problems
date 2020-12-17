package Tree;

public class BurnTreeByLeaf {
    //https://www.interviewbit.com/problems/burn-a-tree/
    static int res;
    class Data
    {
        int leftDepth;
        int rightDepth;
        int time;
        boolean contains;
        Data()
        {
            leftDepth=rightDepth=0;
            time =-1;
            contains = false;
            
        }
    }
    public int solve(TreeNode root, int target)
    {
        Data temp = new Data();
        getResultUtil(root, target, temp);
        return res;
    }
    public void getResultUtil(TreeNode node , int target, Data data)
    {
           if(node == null)
           return;
           if(node.left == null && node.right == null)
           {
               if(node.val == target)
               {
                   data.time = 0 ;
                   data.contains = true;


               }
           }
           Data leftData = new Data();
           getResultUtil(node.left,target,leftData);
           
           Data rightData = new Data();
           getResultUtil(node.right, target, rightData);

           data.time = leftData.contains ? leftData.time +1:-1;
           if(data.time == -1)
              data.time = rightData.contains ? rightData.time+1:-1;

           data.contains = leftData.contains || rightData.contains;


           data.leftDepth = node.left == null ? 0: 1 + Math.max(leftData.leftDepth,leftData.rightDepth);
           data.rightDepth = node.right == null ? 0: 1 + Math.max(rightData.leftDepth, rightData.rightDepth);


           // needs to update answer

           if(data.contains)
           {
                if(leftData.contains)
                {
                    res = Math.max(res, data.time + data.rightDepth);
                }
                else if(rightData.contains)
                res = Math.max(res, data.time +data.leftDepth);
           }
    }
}
