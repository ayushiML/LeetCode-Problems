package Arrays;

public class NextGreaterPalindrome {
    //https://www.interviewbit.com/problems/next-smallest-palindrome/
    public String solve(String A) {
        
        int n = A.length();
        
        char[] num = A.toCharArray();
        if(isAll(num, n))
        {
            char[] ans = new char[n+1];
            ans[0] = ans[n] = '1';
            for(int i = 1 ; i < n; i++)
              ans[i] ='0';
            num = ans;  
        }
        else
        {   int[] ans = new int[n];
            for(int i = 0 ; i < n; i++)
            ans[i] = num[i] -'0';

            ans = utilfunction(ans, n);
            for(int i = 0 ; i < n; i++)
            num[i] = (char)ans[i];

        }
        return num.toString();
        
    }
    private boolean isAll(char[] num, int n) {
		for (int i = 0; i < n; i++) 
            if (num[i]-'0' != 9) 
                return false; 
        return true;
	}

    public int[] utilfunction(int[] num , int n)
    {   
        int mid = n/2;
        int i = mid-1;
        int j = (n % 2 == 0) ? mid: mid+1;
        boolean leftSmaller = false;

        if(i >= 0 && num[i] == num[j])
         {
             i--;
             j++;
         }
         if(i < 0 || num[i] < num[j])
         {
             leftSmaller = true;

         }
         while(i >= 0)
         {
             num[j++] = num[i--];
         }    
         if(leftSmaller)
         {
             int carry = 1;
             if(n % 2 == 1)
             {
                 num[mid] = (num[mid] +carry); 
                 carry  = (num[mid]) %10;
                 num[mid] = ((num[mid]) / 10);
             }
             i = mid-1;
              j = (n % 2 == 0) ? mid: mid+1;
             while(i >= 0 && carry > 0 )
             {
                num[i] = (num[i] +carry); 
                carry  = (num[i] ) %10;
                num[i] = ((num[i]) / 10);
                num[j++] = num[i--];

             }

         }
         //return num;  
        
        
        return num;
    }
}
