public class MaxProductSubArray {
    
public static void main(String[] args) {
    int arr[] = { 1, -2, -3, 0, 7, -8, -2 }; 
        System.out.println("Maximum Sub array product is "
                           + maxSubarrayProduct(arr)); 
}

private static int maxSubarrayProduct(int[] arr) {
   int max_ending_here = 1;
   int min_ending_here = 1;
   int max_so_far = 1;
   int n = arr.length;
   int flag = 0;
   for(int i = 0 ; i < n ; i++ )
   {
       if(arr[i] > 0)
       {
           max_ending_here = max_ending_here*arr[i];
           min_ending_here = Math.min(min_ending_here*arr[i] , 1);
           flag = 1;
       }
       else if(arr[i] == 0)
       {
           max_ending_here = 1;
           min_ending_here = 1;
       }
       else 
       {   int temp = max_ending_here;
           max_ending_here = Math.max(min_ending_here*arr[i],1);
           min_ending_here = temp*arr[i];
       }
       if(max_ending_here > max_so_far)
       max_so_far= max_ending_here;
   }
   if(flag == 0 && max_so_far == 1)
   return 0;
   
   return max_so_far;
}
    
}
