package String;

import java.util.Arrays;

public class PasswordDecyrtion {
    static boolean valid(String p, String s) {
        int len = p.length();

        int sLen = s.length();
        if (sLen + 1 < len)
            return false;
        // window size = len
        int[] countP = new int[26];
        int[] countS = new int[26];
        // char[] encrpt = s.toCharArray();
        for (int i = 0; i < len; i++) {
            countP[p.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(countP));
        System.out.println("====================p=================");
        int i = 1;
        for (i = 1; i + len < sLen; i++) {
            int j = i + len;
            // String dummy = s.substring(i,j);
            for (int x = i; x < j; x++) {
                countS[s.charAt(x) - 'a']++;

            }
            System.out.println(Arrays.toString(countS));
            if (isEqual(countS, countP))
                return true;
             Arrays.fill(countS, 0);   
        }
        return false;
    }

    static boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String p = "zyxabc";
        String s = "fghcxabyzbvf";
        System.out.println(valid(p, s));
    }
}
