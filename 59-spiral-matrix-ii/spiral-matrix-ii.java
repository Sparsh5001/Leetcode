class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int i = 0;
        int j = 0;
        int val = 1;
        while(val<=n*n){
            
            while(j<n && val<=n*n && matrix[i][j]==0){
                matrix[i][j] = val;
                val++;
                j++;
            }
            j--;
            i++;

            while(i<n && val<=n*n && matrix[i][j]==0){
                matrix[i][j] = val;
                val++;
                i++;
            }
            i--;
            j--;

            while(j>=0 && val<=n*n && matrix[i][j]==0){
                matrix[i][j] = val;
                val++;
                j--;
            }
            j++;
            i--;

            while(i>=0 && val<=n*n && matrix[i][j]==0){
                matrix[i][j] = val;
                val++;
                i--;
            }
            i++;
            j++;

            
        }






    return matrix;
    }
}