package Arrays;

public class FirstPositiveNum {
    public int firstMissingPositive(int[] nums) {
       
        
        boolean flag = false;
        int n = nums.length;
        
        for(int i =0 ; i < n ; i++)
        {
            if(nums[i] == 1)
                flag = true;
        }
        if(!flag)
            return 1;
        
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i]  <= 0 || nums[i] > n)
                nums[i] =1;
            
        }
        for(int i = 0 ; i < n ; i++)
        {
            nums[(nums[i]-1) % n] += n;
        }
        
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] <= n)
                return i+1;
        }
        return n+1;
    }
}
