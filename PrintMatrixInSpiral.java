public class PrintMatrixInSpiral {

        public static int[][] generateMatrix(int len) {
            int index = 1;
            int[][] ans = new int[len][len];
            int k = 0;
            int l = 0;
            int m = len;
            int n = len;
            int i = 0;
            while (k < m && l < n) {
                for (i = l; i < n; i++) { // ans.add(matrix[k][i]);
                    ans[k][i] = index++;
                }
                k++;
                for (i = k; i < m; i++) {
                    // ans.add(matrix[i][n-1]);
                    ans[i][n - 1] = index++;
                }
                n--;
                if (k < m) {
                    for (i = n - 1; i >= l; i--) {// ans.add(matrix[m-1][i]);
                        ans[m - 1][i] = index++;
                    }
                    m--;
                }
                if (l < n) {
                    for (i = m - 1; i >= k; i--)
                        ans[i][l] = index++;
                    // ans.add(matrix[i][l]);
                    l++;
                }

            }
            return ans;
        }

        public static void main(String[] args) {
            int[][] ans = generateMatrix(3);
        }
    
}
