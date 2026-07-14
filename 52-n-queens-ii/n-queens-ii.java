class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return solver( board ,  0  , 0);       
    }

    public int solver( int[][] board , int i , int count){
        if(i==board.length){
            count++;
            return count;
        }
        for(int k = 0 ; k<board.length ; k++){
            if(check(board,i,k)){
                board[i][k]=1;
                count = solver(board,i+1,count);
                board[i][k]=0;
            }
        }
        return count;
    }

    public boolean check(int[][] board , int i , int k ){
        int x = i;
        int y = k;
        while(x>=0){
            if(board[x--][y]==1){
                return false;
            }
        }
        x=i;
        y=k;
        while(x>=0 && y>=0){
            if(board[x--][y--]==1){
                return false;
            }
        }
        x=i;
        y=k;
        while(x>=0 && y<board.length){
            if(board[x--][y++]==1){
                return false;
            }
        }
        return true;
    }

}