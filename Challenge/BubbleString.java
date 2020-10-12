package Challenge;

import java.util.HashSet;
import java.util.Set;

public class BubbleString {
    public static boolean buddyStrings(String A, String B) {

        int n = A.length();
        int m = B.length();

        if (n != m)
            return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (s.contains(A.charAt(i)))
                    return true;
                s.add(A.charAt(i));
            }
            return false;
        }

        int counter = 0;
        int aChars = 0;
        int bChars = 0;

        for (int i = 0; i < n; i++) {
            aChars += A.charAt(i);
            bChars += B.charAt(i);

            if (A.charAt(i) != B.charAt(i))
                counter++;

        }
        return counter == 2 && (aChars == bChars);
    }

    public static void main(String[] args) {
        {   String a = "abcd";
            String b = "abdc";
            System.out.println(buddyStrings(a,b));
        }
    }
    
}
