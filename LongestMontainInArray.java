public class LongestMontainInArray {
public static void main(String[] args) {
    int[] arr = {2,1,4,7,3,2,5};
    System.out.println(longestMountain(arr));
}
public static int longestMountain(int[] arr) {
    int longestmontain= 0;
   for(int i = 1 ; i < arr.length-1; i++)
   {
       if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
       {int left = i-1;
        int right = i+1;
        
           while(left > 0 && arr[left] > arr[left-1])
               left--;
        while(right < arr.length-1 && arr[right] > arr[right+1])
            right++;
        longestmontain = Math.max(longestmontain, right-left+1);
       }
   }
   return longestmontain;
}
}
