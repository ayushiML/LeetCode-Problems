
import java.io.*; 
import java.util.*; 
  
public class SortVeryLong {

    // Function for sort an array of large numbers 
    // represented as strings 
    static void sortLargeNumbers(String arr[]) 
    { 
        // Refer below post for understanding below expression: 
        // https://www.geeksforgeeks.org/lambda-expressions-java-8/  
        Arrays.sort(arr,  (o1,o2)->{
            if(o1.length() != o2.length())
                return o1.length() - o2.length();
                else
                return o1.compareTo(o2);
        }
            
        );
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String arr[] = {"5", "1237637463746732323", 
                        "97987", "12" }; 
        sortLargeNumbers(arr); 
        for (String s : arr) 
            System.out.print(s + " "); 
    } 
} 

