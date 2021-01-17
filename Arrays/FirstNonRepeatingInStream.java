package Arrays;

import java.util.*;

public class FirstNonRepeatingInStream {
    final static int MAX_CHAR = 256; 
  
    static void findFirstNonRepeating()
    {
        List<Character> list = new LinkedList<>();
        boolean[] repeated = new boolean[256];

        String stream = "geeksgggku";
        for(int i = 0 ; i < stream.length();i++)
        {
            char x = stream.charAt(i);

            if(!repeated[x])
            {
                if(!list.contains((Character)x))
                {
                    list.add((Character)x);

                }else{

                    list.remove((Character)x);
                    repeated[x] = true;
                }
            }

            if(list.size() != 0)
              {
                  System.out.println(list.get(0));
              }
              else
              {
                System.out.println("np");
              }
        }


    }
    public static void main(String[] args) {
        findFirstNonRepeating();
    }

}
