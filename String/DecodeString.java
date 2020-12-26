package String;

public class DecodeString {
    
        public static String decodeAtIndex(String S, int K) {
            StringBuilder sb = new StringBuilder("");
            
            
            int n = S.length();
            for(int i = 0 ; i < n ; i ++)
            {
                if(S.charAt(i)> 48 && S.charAt(i) <= 57)
                {
                    int count = S.charAt(i)-48;
                    String add = sb.substring(0, sb.length());
                    while(count > 1 )
                    {
                        sb = sb.append(add);
                        count--;
                    }
                        
                    
                }
                else
                sb = sb.append(S.charAt(i));
            }
            System.out.println(sb);
            String ans =  sb.toString();
            return ans.substring(K, K+1);
        }
    public static void main(String[] args) {
        decodeAtIndex("leet2code3", 10);
    }

}
