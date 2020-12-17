package SlidingWindow;

public class MinSwapsToGroup1s {
    
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 0, 1, 1};
        System.out.println(minswaps(arr));
    }
    public static int minswaps(int[] arr)

    {   int n = arr.length;

        int min = n;
        int ones = 0 ;
        for(int i = 0 ; i < n ; i++)
        {
            if(arr[i] == 1)
              ones++;
        }
        // window size = ones 
        if(ones == 0 || ones == 1)
        return 0;
        int curr= 0 ;

        for(int i = 0 ; i < ones; i++)
        {
            if(arr[i] == 1) curr++;
             
        }
        min = Math.min(min, ones-curr);
        for(int i = ones ; i < n ; i++)
        { 
             if(arr[i-ones] == 1) curr--;
             if(arr[i] == 1) curr++;
             if(min > ones-curr)
             {
                 min = ones-curr;
             }

        }






        return min;
    }
}
