import java.util.PriorityQueue;

public class KLargestNumber {

    // min heap : O(k +(n-k)logk)
    public static int findKthLargest(Integer[] arr, int k) {
        int n = arr.length;
        if (n < k)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }

        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }

// quick select method

    public static int findKthLargestQ(int[] nums, int k) {
        int ans =  quickSort(nums, 0 , nums.length-1, k);
          for(int i = 0 ; i < nums.length ;i++)
          {
              System.out.println(nums[i]);
          }
          return ans;
          
          
      }
      public static int quickSort(int[] nums , int low , int high , int k )
      {
          if(k > 0 && k <= (high-low +1))
          {
              int pi = parition(nums , low , high);
              if(pi - low +1 == k)
                  return nums[pi];
              
              if(pi - low +1 < k )
                  
              return quickSort(nums , pi+1, high , k -(pi - low +1));
              return quickSort( nums , low , pi-1, k);
          }
           return Integer.MAX_VALUE; 
          
      }
      public static  int parition(int[] nums , int low , int high)
      {
          int pivot = nums[high];
          int i = low ;
          for(int j = low ; j <= high-1 ; j++)
          {
              if(nums[j] >= pivot)
              {
                //  i++;
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j] = temp;
                  i++;
              }
          }
                  int temp = nums[i];
                  nums[i] = nums[high];
                  nums[high] = temp;
          return i;
          
      }
}
