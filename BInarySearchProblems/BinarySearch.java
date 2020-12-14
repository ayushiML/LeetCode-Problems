package BInarySearchProblems;
public class BinarySearch {
    public static int search(int[] nums, int target) {
        return binarySearch( nums, 0 , nums.length-1, target);
    }
    public static int binarySearch(int[] arr, int low , int high, int target)
    {
        while(low < high && low < arr.length && high >= 0 )
        {
            int mid = low +(high-low)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target )
            {
                high = mid-1;
            }
            else if (arr[mid] < target )
                low = mid+1;
        }
        if(low == high && arr[low] == target)
            return low;
        
        return -1;
    }
    public static void main(String[] args)
    {
 
        int arr[] = { -1,0,3,5,9,12 };
        int target = 9;
        //int n = arr.length;
        System.out.println(search(arr,  target));
    }
    
}

