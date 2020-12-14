package BInarySearchProblems;

public class RowWithMax1s {
    //https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
    int rowWithMax1s(int arr[][], int n, int m) {
       
        int max_row = -1;
        int max = -1;
        for(int i  = 0; i < n ; i++)
        {
           int index =  binarySearch(arr[i], 0 , m-1);
           if(index == -1)
             continue;
           int  count = m - index;
           if( count > max)
           {
               max= count;
               max_row = i;
           }
        }
        return max_row;
    }
    public int binarySearch(int[] arr , int start, int end)
    {
        if(end >= start)
        {
            int mid = start + (end-start) /2;
            if((mid == 0 || arr[mid-1] == 0)&&arr[mid] ==1)
              return mid;
            else if(arr[mid] == 0)
              return binarySearch(arr, mid+1, end);
            else
              return binarySearch(arr, start, mid-1);
        }
        
        return -1;
    }
}
