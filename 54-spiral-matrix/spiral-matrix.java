class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> Out = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        
        int i = 0 ;
        int j = 0;
        while(Out.size() < total){

            while(j < matrix[i].length && matrix[i][j] != -101){
                Out.add(matrix[i][j]);
                matrix[i][j] = -101;
                j++;
            }
            j--;
            i++;

            while(i < matrix.length && matrix[i][j] != -101){
                Out.add(matrix[i][j]);
                matrix[i][j] = -101;
                i++;
            }
            i--;
            j--;

            while(j>=0 && matrix[i][j] != -101){
                Out.add(matrix[i][j]);
                matrix[i][j] = -101;
                j--;
            }
            j++;
            i--;

            while(i >= 0 && matrix[i][j] != -101){
                Out.add(matrix[i][j]);
                matrix[i][j] = -101;
                i--;
            }
            i++;
            j++;
        




        }
        return Out;
    }
}