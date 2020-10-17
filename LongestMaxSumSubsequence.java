public class LongestMaxSumSubsequence {
    public static void main(String[] args) {
        int[] arr = { 1,100,2,3,99};
        System.out.println(maxSumIS(arr, 5));
    }

    public static int maxSumIS(int arr[], int n) 
	{  
	    int[] val = new int[n+1];
		val[0] = arr[0];
		if( n == 0)
		return 0;
		int max = val[0];
	    for(int i = 1 ; i < n ; i++)
	    {
	        int  j = 0;
	        while(j < i)
	        {  if(arr[j] < arr[i])
				val[i] = Math.max(val[i], arr[i] + val[j]);
				else
				val[i] = Math.max(val[i],arr[i]);
	        if(max< val[i])
	           max= val[i];
	             j++;
			}
			System.out.println(val[i]);
	    }
	    return max;
	} 
}
