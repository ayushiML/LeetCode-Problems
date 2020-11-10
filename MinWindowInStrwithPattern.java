public class MinWindowInStrwithPattern {
    //https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/

    public static void main(String[] args) 
    { 
        String str = "this is a test string"; 
        String pat = "tist"; 
      
    System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat)); 
    }
    static int no_of_chars = 256;
    private static String findSubString(String str, String pat) {
       
        int len1 = str.length(); 
        int len2 = pat.length(); 
      
        // check if string's length is less than pattern's 
        // length. If yes then no such window can exist 
        if (len1 < len2) 
        { 
            System.out.println("No such window exists"); 
            return ""; 
        } 
      
        int hash_pat[] = new int[no_of_chars]; 
        int hash_str[] = new int[no_of_chars]; 
      
        // store occurrence ofs characters of pattern 
        for (int i = 0; i < len2; i++) 
            hash_pat[pat.charAt(i)]++;

        int start = 0;
        int start_index = -1;
        int min = Integer.MAX_VALUE;
        int count =0;
        for(int j = 0 ; j <len1; j++)
        {
            hash_str[str.charAt(j)]++;
            if(hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] )
            {
                count++;
            }
            if(count == len2)
            {
            //remove starting unwanted charaters in window of str hash
            while(hash_pat[str.charAt(start)] < hash_str[str.charAt(start)] || hash_pat[str.charAt(start)] == 0)
            {   if(hash_pat[str.charAt(start)] < hash_str[str.charAt(start)])
                hash_str[str.charAt(start)]--;
                start++;
            }
            int len = j-start+1;
            if(len < min)
            {
                min = len;
                start_index = start;
            }

            }
        }
        if (start_index == -1) 
        { 
        System.out.println("No such window exists"); 
        return ""; 
        } 
      
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index + min); 
    }
}
