package Tree;


class CheckBST
{Node prev = null;
    public boolean isValidinorder(Node node)
    {
       
        if(node == null)
            return true;
        else
        {
            if(!isValidinorder(node.left))
                return false;
            
            if(prev != null && prev.val >= node.val)
                return false;
            prev = node;
            return isValidinorder(node.right);
            
        }
    }
 public boolean isValidBST(Node root) {
        return   isValid(root, null, null);
      }
      public boolean isValid(Node node, Integer min, Integer max)
      {
          if(node == null)
          return true;
  
          if(min != null && node.val <= min)
              return false;
          if(max != null && node.val >= max)
              return false;
  
          return isValid(node.left,min, node.val) && isValid(node.right,node.val, max);
      }

    public static void main(String[] args) {
        
    }
}