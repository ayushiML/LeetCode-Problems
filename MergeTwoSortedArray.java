import java.util.Arrays;

public class MergeTwoSortedArray {
    // https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20}; 
    static int arr2[] = new int[]{2, 3, 8, 13}; 
    public static void main(String[] args)  
    { 
        merge(arr1.length,arr2.length); 
        System.out.print("After Merging nFirst Array: "); 
        System.out.println(Arrays.toString(arr1)); 
        System.out.print("Second Array:  "); 
        System.out.println(Arrays.toString(arr2)); 
    }

    private static void merge(int n, int m) {
        for(int i = m-1 ; i >=0 ; i--)
        {  int j , last = arr1[n-1];
            for(j = n-2; j >= 0 && arr2[i] < arr1[j]; j--)
            {
                arr1[j+1] = arr1[j];
            }
          
            if(j != n-2 || last > arr2[i])
            {   arr1[j+1] = arr2[i];
                arr2[i] = last;
            }


        }


    }

}
