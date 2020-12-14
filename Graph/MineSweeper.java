package Graph;

public class MineSweeper
{
    public char[][] updateBoard(char[][] board, int[] click) {
            char c = board[click[0]][click[1]];
            int[][] dirs = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
            if (c == 'M') {
                board[click[0]][click[1]] = 'X';
            } else if (c == 'E') {
                dfs(board, click[0], click[1], dirs);
            }
            return board;
        }
    
    
        private void dfs(char[][] board, int row, int col, int[][] dirs) {
            int rows = board.length;
            int cols = board[0].length;
            board[row][col] = 'B';
            int count = 0;
            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (isValid(nRow, nCol, rows, cols) && board[nRow][nCol] == 'M') count++;
            }
            if (count > 0) board[row][col] = (char) (count + '0');
            else {
                for (int[] dir : dirs) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if (isValid(nRow, nCol, rows, cols) && board[nRow][nCol] == 'E')
                        dfs(board, nRow, nCol, dirs);
                }
            }
        }
    
        private boolean isValid(int row, int col, int rows, int cols) {
            return (row >= 0 && row < rows && col >= 0 && col < cols);
        }}