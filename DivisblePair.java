import java.util.Arrays;

public class DivisblePair {
    public static void main(String[] args)  
    { 
        int arr[] = {3, 2, 4, 2, 6}; 
        int n = arr.length; 
  
        System.out.println(freqPairs(arr, n)); 
    }

    private static int freqPairs(int[] arr, int n) {



        int max= Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max+1];

        for(int i = 0 ; i < n ; i++)
        {
            freq[arr[i]]++;
        }
          int count =0; 
        for(int i = 0 ; i <n ; i++)
        {
            for(int j = 2*arr[i]; j < max ; j += arr[i])
            {
                if(freq[j]!= 0)
                {
                    count+=freq[j];
                }
            } 
            if(freq[arr[i]] > 1)
            {
                count += freq[arr[i]] -1;
                freq[i]--;
            }
        }
        return count;
    }

}
