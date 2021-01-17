package String;

public class SmallestStringlengthContainsOtherString {
    //https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
    public static void main(String[] args) {
        String str = "this is a test string"; 
        String pat = "tist"; 
      
    System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat)); 
    }

    static final int no_of_chars = 256; 
      
    // Function to find smallest window containing 
    // all characters of 'pat' 
    static String findSubString(String str, String pat) 
    {
        int[] hashS = new int[no_of_chars];
        int[] hashP = new int[no_of_chars];
        int lenS = str.length();
        int lenP = pat.length();


        for(int i = 0 ; i < lenS; i++)
        {
            hashP[pat.charAt(i)]++;

        }
        int count = 0 ;
        int start = 0 ;
        int start_index = -1;
        int min = Integer.MAX_VALUE;


        for(int i = 0; i < lenS; i++)
        {
            hashS[str.charAt(i)]++;

            if(hashP[str.charAt(i)] != 0 && hashP[str.charAt(i)] >= hashS[str.charAt(i)])
              count++;

            if(count == lenP)
            {
                while(hashS[str.charAt(start)] > hashP[str.charAt(start)] || hashP[str.charAt(start)] == 0)
                 {

                    if(hashS[str.charAt(start)] > hashP[str.charAt(start)])
                       hashS[str.charAt(start)]--;

                       start++;
                 }
                 int len = i - start +1;
                 
                 if(min > len)
                 {
                     min = len ;
                     start_index = start;
                 }


            }  
        }
        if(start_index == -1)
           return null;

        return str.substring(start_index, start_index+min);   
    }
}
