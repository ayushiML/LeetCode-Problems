package Greedy;

public class GasStation {

        public static int canCompleteCircuit(final int[] A, final int[] B) {
        
            int n = A.length;

            int sum = 0 ;
            int diff = 0;
            int start = 0;
            for(int i = 0 ; i < n ; i++ )
            {
            sum += sum +A[i]-B[i];
            if(sum < 0)
            {sum = 0 ;
            start = i+1;
            diff =  diff+sum;   

        }

            }
            return (diff+sum > 0 )? start:-1;
    }
    public static void main(String[] args) {
      int[]  A =  {6,3,7 };
    int[] B =  {4,6,3};
    System.out.println(canCompleteCircuit(A,B));

    }
}
