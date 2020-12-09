import java.util.Arrays;

public class NextGreaterString {
    public static void main(String[] args) {
        String str ="aan";
        nextGreaterString(str);

    }

    private static void nextGreaterString(String str) {
             int n = str.length();
             int i = n-1;
             for( i = n-1; i> 0; i--)
             {
                 if(str.charAt(i) > str.charAt(i-1))
                 break;
             }
             // find number greater than str[i-1] after i-1 and 
             int min = i ;
             int x = str.charAt(i-1);
             for(int j = i+1; j < n; j++)
             {
                 if(str.charAt(j) >x && str.charAt(j) < str.charAt(min))
                  { min= j ;  }

                     
             }
            // if( min == i )
             //  System.out.println("there is no string greater than input");

               char[] ch = str.toCharArray();

               char c = ch[min];
               ch[min] = ch[i-1];
               ch[i-1] = c;
               Arrays.sort(ch, i, n-1);

               System.out.println(ch);


    }
}
