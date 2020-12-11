package String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NonRepeatingInStream {
    public static String solve(String A) {

        // online algo
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[i] = -1;

        }
        int n = A.length();
        if (n == 0)
            return "";

        StringBuffer sb = new StringBuffer("");
        index[A.charAt(0) - 'a'] = 0;
        sb.append(A.charAt(0));

        if (n < 2)
            return sb.toString();

        for (int i = 1; i < n; i++) {
            int x = A.charAt(i) - 'a';
            if (index[x] != -1)
                index[x] = Integer.MAX_VALUE;
            else
                index[x] = i;
            int min_index = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (index[j] != -1 && index[j] < min_index)
                    min_index = index[j];

            }
            if (min_index != Integer.MAX_VALUE)
                sb.append(A.charAt(min_index));
            else
                sb.append('#');

        }
        return sb.toString();
    }
    public static String solveWithQueue(String A)
    {

       Deque<Character> d = new ArrayDeque<>();
       // if( !q.isEmpty() && A.charAt(q.peekLast()) == arr[i])  
       
       int n = A.length();
       if (n == 0)
           return "";

       StringBuffer sb = new StringBuffer("");
       sb.append(A.charAt(0));

       if (n < 2)
           return sb.toString();
       
        d.offerLast(A.charAt(0));
        for(int i = 1 ; i < n ; i++)
        {
            if(!d.remove(A.charAt(i)))
               {
                   d.offerLast(A.charAt(i));
               }
               if(d.isEmpty())
                 sb.append('#');
               else
                 sb.append(d.peekFirst());
            System.out.println(Arrays.toString(d.toArray()));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "jpxvxivxkkthvpqhhhjuzhkegnzqriokhsgea";
        System.out.println(solve(s));

    }
}

