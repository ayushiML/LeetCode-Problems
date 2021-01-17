package SegmentTree;

public class CreateSortedArraythroughInstructions {
    int[] trees;
    public int createSortedArray(int[] instructions) {
        int m = 1000000007;
        int N = 100001;
        
        //trees.resize(4*N,0);
       trees = new int[4*N];
        
        int cost = 0;
        for(int i=0;i<instructions.length;i++)
        {
            int less_count = query(0,0,N,0,instructions[i]-1);
            int greater_count = query(0,0,N,instructions[i]+1,N);
            update(0,0,N,instructions[i]);
            cost = (cost + Math.min(less_count,greater_count))%m;
        }
        
        return cost;
    }
     public int query(int index, int low, int high, int l, int r){
          if(l <= low && high <= r)
            return trees[index];
          if( l > high || r < low )
            return 0;
            
          int mid = low +(high - low)/2;
          int left = query(2*index +1 , low , mid , l , r);
          int right = query (2*index +2 , mid+1 , high , l , r );
          
          return left +right;
    }
    void update(int index,int low, int high, int position){
        if(low==high)
        {
            trees[index]++;
            return;
        }
        else
        {
            int mid = low + (high-low)/2;
            if(position<=mid)
                update(2*index + 1,low,mid,position);
            else
                update(2*index + 2,mid+1,high,position);
            trees[index] = trees[2*index+1]+trees[2*index+2];
        }
       
    }
}
