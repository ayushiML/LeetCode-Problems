package Arrays;

public class DuplicatesFirstN {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 2};
        int arr1[] = { 1, 6, 3, 1, 3, 6, 6 }; 
        //printDuplicates(arr);
        printDuplicatesWithOrder(arr1);
    }
    public static void printDuplicates(int[] arr)
    {
        int n = arr.length;
        for(int i = 0  ; i < n ; i++)
        {
            int  index = arr[i] %n ;
            arr[index] += n ;
        }


        for(int i = 0  ; i < n ; i++)
        {
            if( arr[i]/ n >= 2)
              {
                  System.out.println(i + " with frequency :" + arr[i] % n);
              }
        }
    }
    public static void printDuplicatesWithOrder(int[] arr)
    {   int n = arr.length;
        for(int i = 0  ; i < n ; i++)
        {
            if(arr[arr[i] % n] >= n)
            {
              if(arr[arr[i]%n] < 2*n)
              System.out.println(arr[i] % n);

            }
            arr[arr[i] % n] += n;
        }
    }
}
