package Greedy;

public class MajorityElement {
    public static int majorityElement(final int[] A) {
        //find candiate
        // sorting would be O(nlogn)
        //map O(n) and O(n) space 
        //below is O(n) time complexity 
        //QUes: https://www.interviewbit.com/problems/majority-element/
        int n = A.length;
        
        int maj_index = 0 ; int count = 1;
        for(int i =1 ; i < n;i++)
        {
            if(A[maj_index] == A[i])
            count++;
            else
            count--;
            if(count == 0 )
            {
                maj_index = i;
                count = 1;
            }
        }
        int candiate = A[maj_index];

        //now check whether candiate is correct or not 
        count = 0 ;
        for(int i = 0 ; i <n ;i++)
        {
            if(A[i] == candiate)
            count++;
        }
        if(count > n/2)
          return candiate;
       return -1;
      }
      public static void main(String[] args) {
          System.out.println(majorityElement(new int[]{1,2,2,3,2}));
      }
}
