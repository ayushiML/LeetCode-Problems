package Dp;
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0)
             return n ;
        if(n == 1 && s.charAt(0) == '0')
            return 0;
        if( n == 1)
            return 1;
        //==== base=====
        Integer[] mem = new Integer[n];
        return numDecodings(s, 0, mem);
        
    }
    /*public int numDecodings(String s , int p)
    {
        int n = s.length();
        if( p == n) return 1;
        if(s.charAt(p) == '0')return 0;
        int res = numDecodings(s, p+1);
        if(p < n-1 && ((s.charAt(p) == '1') || (s.charAt(p) == '2' && s.charAt(p+1) < '7')))
            res+= numDecodings(s, p+2);
        return res;
    }
    */
    // memoziation
    public int numDecodings(String s , int p, Integer[] mem)
    {
        int n = s.length();
        if( p == n) return 1;
        if(s.charAt(p) == '0')return 0;
        if(mem[p] != null) return mem[p];
        int res = numDecodings(s, p+1, mem);
        if(p < n-1 && ((s.charAt(p) == '1') || (s.charAt(p) == '2' && s.charAt(p+1) < '7')))
            res+= numDecodings(s, p+2, mem);
        return mem[p] =res;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        int ans = decodeWays.numDecodings("123");
        System.out.println(ans);

    }
}
