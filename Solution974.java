import java.util.Arrays;


public class Solution974 {
  
    private static int subarraysDivByK;
    public static int subarraysDivByK(int[] arr, int k) {
        /*
         * sum(i-j) = sum(0,j) - sum(0,i); quatient *k + rem = number sum(i-j) =
         * (q1-q2)*k +(rem1- rem2) rem1 == rem2 give subarray with divisible by k
         * 
         * 
         * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

 

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
         */


        int n = arr.length;
        int[] mod = new int[k];
        Arrays.fill(mod, 0);

        int curr_sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {

            curr_sum += arr[i];
            mod[((curr_sum % k) + k) % k]++;

        }
        for (int i = 0; i < k; i++) {
            if (mod[i] > 1)

            {
                count += (mod[i] * (mod[i] - 1)) / 2;

            }
        }
        count += mod[0];
        return count;

    }

    public static void main(String[] args) {

        int arr[] = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        
        System.out.println(subarraysDivByK(arr, k));
        int arr1[] = { 4, 5, 0, -12, -23, 1 };
        int k1 = 5;
      
        subarraysDivByK = subarraysDivByK(arr1, k1);
        System.out.println(subarraysDivByK); 
    } 

}
