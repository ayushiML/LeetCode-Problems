package Arrays;

public class TRappingWater {
    public static int totalwater(int[] arr)
    {
        int leftmax = 0;
        int rightmax = 0 ;
        int low = 0 ;
        int high = arr.length;
        int result =0;
        while(low <= high)
        {
            if(arr[low] < arr[high])
            {
                if(leftmax < arr[low])
                leftmax = arr[low];
                else
                result += leftmax-arr[low];
                low++;
            }
            else
            {
                if(rightmax < arr[high])
                 rightmax = arr[high];
                 else
                 result += rightmax- arr[high];
                 high--;

            }

        }
        
        return result;
    }
}
