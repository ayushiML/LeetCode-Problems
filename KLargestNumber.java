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
}
