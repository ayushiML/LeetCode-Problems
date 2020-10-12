package MCM;
class MAtrixMulMinCost { 
    //https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    //Ai = arr[i-1] * arr[i]
    //i should be from 1 and j from n-1;
    //invalid = > i==j size 1 is also invalid
    static int MatrixChainOrder(int p[], int n) 
    { 
      return  solve(p, 1 ,  p.length-1);
    } 
    //static int ans =Integer.MAX_VALUE;
    // k is from i to j-1  partions valid= i, k and k+1,j
    private static int solve(int[] p, int i, int j) {
        if(i==j) return 0;
        int ans =Integer.MAX_VALUE;
        for(int k = i; k <= j-1 ;k++)
        {
            int temp_ans = solve(p, i, k )+solve (p, k+1,j)+ p[i-1]*p[k]*p[j];
            ans=Math.min(ans,temp_ans);
        }
        return ans;
    }

    // Driver program to test above function
    public static void main(String args[]) 
    { 
        int arr[] = new int[] { 1, 2, 3, 4 }; 
        int size = arr.length; 
  
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, size)); 
    } 
} 