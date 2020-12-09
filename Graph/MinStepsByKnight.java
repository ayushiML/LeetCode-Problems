package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MinStepsByKnight {
    //https://www.interviewbit.com/problems/knight-on-chess-board/
    static class Cell
    {
        int x;
        int y;
        int dis;
        Cell(int x, int y , int dis)
        {
            this.x= x;
            this.y = y;
            this.dis = dis;
            
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 }; 
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        boolean[][] visited = new boolean[A+1][B+1];
        Queue<Cell> q = new LinkedList<>();
        
        visited[C][D] = true;
        q.add(new Cell(C,D,0));
        
        while(!q.isEmpty())
        {
            Cell first = q.poll();


            if(first.x == E && first.y == F)
            {
                return first.dis;
            }
            for(int i = 0 ; i < 8; i++)
            {
                int x_p = first.x + dx[i];
                int y_p = first.y + dy[i];
                if(isInside(x_p, y_p, A, B, visited) && !visited[x_p][y_p])
                {  
                    visited[x_p][y_p] = true;
                   q.add(new Cell(x_p,y_p,first.dis+1));
                }
            }
        }
       return -1;

    }

    private boolean isInside(int x_p, int y_p, int a, int b, boolean[][] visited) {

         if(x_p <= a && x_p > 0 && y_p <= b && y_p > 0  )
            if(visited[x_p][y_p] == false)
            return true;
        return false;
    }
}
