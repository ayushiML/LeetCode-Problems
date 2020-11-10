package Tree;

public class MaxSizeOneMatrix {
    public static void main(String[] args)  
    { 
        int M[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
              
        printMaxSubSquare(M); 
    }

    private static void printMaxSubSquare(int[][] m) {
        int i,j; 
        int R = m.length;         //no of rows in M[][] 
        int C = m[0].length;     //no of columns in M[][] 
        int S[][] = new int[R][C]; 
        int max_of_s, max_i, max_j;
        for(i = 0; i < R; i++) 
            S[i][0] = m[i][0]; 
      
        /* Set first row of S[][]*/
        for(j = 0; j < C; j++) 
            S[0][j] = m[0][j];
             /* Construct other entries of S[][]*/
        for(i = 1; i < R; i++) 
        { 
            for(j = 1; j < C; j++) 
            { 
                if(m[i][j] == 1)
                {
                    S[i][j] = Math.min(S[i][j-1], 
                    Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                }
                else
                S[i][j] = 0;
            }}
    }
    
}
