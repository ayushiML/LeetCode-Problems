//import javax.lang.model.util.ElementScanner6;

public class SquareRoot {
    public static void main(String args[]) 
    { 
        int x = 11; 
        System.out.println(floorSqrt(x)); 
        System.out.println(SqrtToPrecision(x,3)); 
    }
    private static double SqrtToPrecision(int x , int p)
    {
double ans = 0.0;
int start = 0 ; int end = x;
while(start <= end)
        {int mid = (start+end)/2;
            if(mid*mid == x)
            {
                ans= mid;
                break;
            }
            else if( mid*mid < x)
            {
                start= mid+1;
                ans = mid;
            }else
            {
                end = mid-1;
            }
        }
        double increment = 0.1;
        for(int i = 0 ; i < p; i++)
        {
            while(ans*ans <= x)
            {
                ans += increment;
            }
            ans = ans-increment;
            increment = increment/10;
        }



return (float)ans;
    }
    private static int floorSqrt(int x) {
        int start = 1;
        int end = x ;
        int ans = 0;
        while(start <= end)
        {int mid = (start+end)/2;
            if(mid*mid == x)
            {
                return mid;
            }
            else if( mid*mid < x)
            {
                start= mid+1;
                ans = mid;
            }else
            {
                end = mid-1;
            }
        }
        return ans;
    }
}
