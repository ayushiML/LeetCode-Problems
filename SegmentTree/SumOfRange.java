package SegmentTree;

public class SumOfRange {
    // update operation : O(log n )
    // retrieval : O(log n)
    int[] tree ;
    SumOfRange(int[] arr , int n )
    {
          int x =  (int) Math.ceil(Math.log(n) / Math.log(2));
          int max_size = 2 *(int) Math.pow(2,x) -1;
          tree = new int[max_size];


         constructTree(arr, 0 , n-1 , 0);
    }

    private int constructTree(int[] arr, int ss, int se, int index) {
        if(se == ss)
        {
            tree[index]= arr[ss];
            return arr[ss];
        }
        int mid = ss +(se-ss)/2; 
        tree[index] =constructTree(arr, ss, mid, 2*index+1)+constructTree(arr, mid+1, se, 2*index+2);

        return tree[index];


    }

    private void updateTreeValue(int[] arr , int new_value , int i )
    {
              if( i  > arr.length-1 || i < 0)
              return;
              int diff = new_value - arr[i];
              arr[i] = new_value;
              updateUtil(0, arr.length-1, 0 , diff, i);
    }
    
    private void updateUtil(int ss, int se, int index, int diff ,int i) {

        if(i < ss || i > se)
         return;
        tree[index] = tree[index]+diff;
        if(ss != se)
       {      int mid = ss + (ss-se )/2;
        
        updateUtil(ss, mid, 2*index+1, diff, i);
        updateUtil(mid+1, se, 2*index+2, diff, i);
       }
    }

    private int getSumInRange(int[] arr, int l, int r)
    {   int n = arr.length;
        if(l < 0 || r > n-1)
            {
                System.out.println(" Invalid input ");
                return -1;
            }
         return getSumUtil( l , r, 0, n-1, 0);

    }

    private int getSumUtil( int l, int r, int ss, int se , int index) {
        //if ss and se lies within the query then addition 

        if(l <= ss && r >= se)
           return tree[index];
        if( l > se || r < ss)   
           return 0;
        int mid = ss + (ss-se )/2;
        return   getSumUtil(l, r, ss, mid, 2*index+1) +getSumUtil(l, r, mid+1, se, 2*index +2);

    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11}; 
        int n = arr.length;
        SumOfRange s = new SumOfRange(arr, n);
        System.out.println(s.getSumInRange(arr, 1, 3));
    }

}
