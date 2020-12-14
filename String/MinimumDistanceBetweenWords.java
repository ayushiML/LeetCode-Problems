package String;

public class MinimumDistanceBetweenWords {
    public static void main(String args[]) 
    { 
        
        String s = "geeks for geeks contribute practice"; 
        String w1 = "geeks" ; 
        String w2 = "practice" ; 
        
        System.out.print( distance(s, w1, w2) ); 
    
    }

    private static int distance(String s, String w1, String w2) {
        String[] arr = s.split(" ");
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int w1dist = -1;
        int w2dist = -1;

        for(int i = 0 ; i < len ; i++ )
        {
            if(arr[i].equals(w1))
               w1dist = i;
            if(arr[i].equals(w2))
               w2dist = i;
            
            if(w1dist != -1 && w2dist != -1)
              {
                  int dist = Math.abs(w2dist-w1dist)-1;
                  if(dist < min)
                     min = dist;
              }   
               

        }



        return min;
    }
}
