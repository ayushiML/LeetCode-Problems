package Tree;

public class SumOfPathLeafToLeaf {
    class Res
    {
        int r;
    }
    int maxPathSum(Node root)
    { 
        // code here
        Res res = new Res();
        sumCa(root, res);
        return res.r;
    } 
     int sumCa(Node node , Res res)
{
if(node == null)
  return 0; 

int l = sumCa(node.left, res);
int r = sumCa( node.right, res);
 int temp = 0;
if(l == 0 && r!= 0)
   temp = node.val+ r;
   else if( l != 0 && r==0)
   temp = node.val + l;
   else
     temp = node.val + Math.max(l, r);
int ans = Math.max(temp , node.val + l + r);
res.r = Math.max(res.r , ans);




return temp;
}
}
