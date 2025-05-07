class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        if( target >= matrix[0][0] && target <= matrix[m][n] ){
            int row = BinaryRow(matrix , target , n);
            return binarySearch(matrix , target , row);
        }
        return false;
    }


    public int BinaryRow(int[][] matrix, int target , int n){
        int low = 0;
        int high = matrix.length-1;
        if(high==0){
            return 0;
        }
        while(low <= high){
            int mid = (high + low) / 2;
            if(matrix[mid][n]==target){
                return mid;
            }
            else if(matrix[mid][n] < target){
                low = mid+1;
                if(high==low){
                    return low;
                }
            }
            else{
                high = mid;
                if(high==low+1 && matrix[low][n]<target){
                    return high;
                }
                else if(matrix[low][n]>target){
                    return low;
                }
            }
        }
    return 0;
    }

    public boolean binarySearch(int[][] matrix, int target , int row) {
    int low = 0;
    int high = matrix[row].length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return false;
    }

}

    