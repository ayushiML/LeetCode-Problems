package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

public class DiagonalTraveral {
   
        public void  solve(TreeNode A) {
            HashMap<Integer, Vector<Integer>> map = new HashMap<>();
            diagonalUtil(A, 0  , map);
            ArrayList<Integer> arr = new ArrayList<>();
            for(Entry<Integer, Vector<Integer>> e : map.entrySet())
            {
                System.out.print(e.getValue());
                arr.addAll(e.getValue());
            }
            System.out.println(Arrays.toString(arr.toArray()));
            
        
    }

    private void diagonalUtil(TreeNode a, int d, HashMap<Integer, Vector<Integer>> map) {
        if(a == null)
        return;

        Vector<Integer> diagonal = map.get(d);

        if(diagonal == null)
        {
             diagonal = new Vector<>();
             diagonal.add(a.val);
        }
        else{
              diagonal.add(a.val);
        }
        map.put(d, diagonal);

        diagonalUtil(a.left, d+1, map);
        diagonalUtil(a.right, d, map);
        
    }
    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        DiagonalTraveral diagonalTraveral = new DiagonalTraveral();
        diagonalTraveral.solve(root);
    }
}
