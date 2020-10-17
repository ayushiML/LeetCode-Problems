
public class HeapSort {
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
        //int n = arr.length; 
  
        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
    }
     
    private static void printArray(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    private void sort(int[] arr) {
    int  n = arr.length;
    for(int i = n/2-1; i >= 0 ; i--)
    heapify(arr, n , i);
    for(int i = n-1 ; i >0 ;i--)
   {
    int temp = arr[0];
    arr[0] = arr[i];
    arr[i] = temp;
  // call max hap on reduced heap 

    heapify(arr, i, 0);

    }
    }

    private void heapify(int[] arr, int n, int i) {

        int largest = i ;
        int  l = 2*i +1;
        int  r = 2*i +2;
        if( l <n && arr[l] > arr[largest])
           largest = l;
         if (r < n && arr[r] > arr[largest])
           largest = r ;
            if(largest != i)
            {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                heapify(arr, n , largest);
            }   
    }
    
    
}
