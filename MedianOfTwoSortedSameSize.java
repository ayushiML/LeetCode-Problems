public class MedianOfTwoSortedSameSize {
    public static void main(String[] args) {
        
    }
    public static int median(int[] a , int[] b)
    {
        
        int n = a.length;
        int count = 0 ;
        int m1 =-1;
        int m2 = -1;
        int i = 0 ; 
        int j = 0 ;
        while( count != n+1 )
        {
            if( i==n)
            {
                m1 = m2;
                m2 = b[0];
                break;

            }
            else if(j == n)
            {
                m1 = m2;
                m2 = a[0];
                break;
            }
            if( a[i] <= b[j])
            {
                m1 = m2;
                m2 = a[i];
                i++;
            }
          else
             {
                 m1 = m2;
                 m2 = b[j];
                 j++;

             }



           count++;
        }
  

        return (m1+m2) /2;
    }
}
