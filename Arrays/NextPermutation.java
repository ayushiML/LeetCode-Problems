package Arrays;

import java.util.Arrays;

public class NextPermutation {
    public static int[] nextNumber(int[] arr)
    {
           int n = arr.length;

           int i = 0;
           for(i = n-1 ; i > 0 ; i++)
           {
               if(arr[i] > arr[i-1])
               break;
           }
           if(i == 0)
           {
              Arrays.sort(arr);
              return arr;
           }
           else{
               int min = i ;
               int x = arr[i-1];

               // find element between i+1 to n-1 that is less than min and greater than i-1 
               for(int j = i+1 ; j < n ; j++)
               {
                   if(arr[j] > x && arr[j] < min)
                    min = j ;
               }

               // swap between mid and i-1
               int temp = arr[min];
               arr[min] = arr[i-1];
               arr[i-1] = temp;

               Arrays.sort(arr, i , n );


           }
           return arr;
    }
}
