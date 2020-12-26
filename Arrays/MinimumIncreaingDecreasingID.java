package Arrays;

import java.util.Stack;

public class MinimumIncreaingDecreasingID {
    //https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
    public static void main(String[] args) {
        printSequence("DDIDDIID");
        printsequencewithoutStack("DDIDDIID");
    }
    
    private static void printsequencewithoutStack(String string) {
        int n = string.length();
        char[] result = new char[n+1];
        int count = 1;
//The idea is to iterate over the string and do the following if current character is ‘I’ or string is ended. 
//Assign count in increasing order to each element from current-1 to the next left index of ‘I’ (or starting index is reached).
//Increase the count by 1.

        for(int i = 0 ; i <= n ; i++)
        {
            if(i == n || string.charAt(i) == 'I')
            {
                for(int j = i-1;j >= -1; j++)
                {
                     result[j+1] = (char)((int)'0'+count++);
                     
                     if(j>=0 && string.charAt(j) == 'I')
                     {
                        break;
                     }
                }
            }
        
        }
    }

    private static void printSequence(String string) {
        String result ="";
        Stack<Integer> s = new Stack<>();
        int n = string.length();
        for(int i = 0 ; i <= n ; i++)
        {
            s.push(i+1);
            if(i == n || string.charAt(i) == 'I')
            {   while(!s.isEmpty())
                   { result  +=  String.valueOf(s.peek());
                    result+= " ";
                    s.pop();
                   }
            }

        }
        System.out.println(result);
        
    }

}
