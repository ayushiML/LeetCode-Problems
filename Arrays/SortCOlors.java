package Arrays;

public class SortCOlors {
    //https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] arr) {
       
        int left = 0 ; 
         int right = arr.length-1;
         int curr = 0 ;
         while(curr <= right)
         {
             if(arr[curr] == 0)
             {
                 swap(curr, left, arr);
                 curr++;
                 left++;
                 
             }
             else if(arr[curr] == 2)
             {
                 swap(curr, right,arr);
                 //curr++;
                 right--;
                 
             }
             else
                 curr++;
         }
     }
     public void swap(int i , int j, int[] arr)
     {
         int temp = arr[i] ;
         arr[i] = arr[j];
         arr[j] = temp;
     }
}
