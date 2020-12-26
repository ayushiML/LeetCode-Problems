package Arrays;

import java.util.*;

public class LargerNumberFormedByarray {
    public static String largestNumber(final int[] A) {
        boolean flag = false;
        
        for (int i = 0; i < A.length; i++)
            if(A[i] != 0)
               flag = true;
               
               if(!flag)
               return "0";
        // String str[] = new String[A.length];
        List<String> l = new LinkedList<>();
        
         for (int i = 0; i < A.length; i++)
             l.add(String.valueOf(A[i]));
         Collections.sort(l, new Comparator<String>()
         {
             @Override
             public int compare(String X , String Y )
             {
                 String XY  =X+Y;
                 String YX = Y+X;
                 
                 
                 return XY.compareTo(YX) > 0 ? -1:1;
             }
         });
         String s = "";
         Iterator i = l.iterator();
         while(i.hasNext())
         {
             s+=(i.next());
         }
         return s;
         
     } 
}
