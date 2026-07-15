class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j<board[0].length ; j++){
                 if(solver(board , word , i , j , 0)){
                    return true;
                 }
            }
        }
        return false;
    }


    public boolean solver(char[][] board, String word , int i , int j , int k){


        if(k==word.length()){
            return true;
        }

        if(i==board.length || j==board[0].length || i<0 || j<0 || board[i][j]=='1'){
            return false;
        }

        if(board[i][j]==word.charAt(k)){
            char hold = board[i][j];
            board[i][j] = '1';
            if(solver(board,word,i-1,j,k+1)){
                return true;
            }
            if(solver(board,word,i+1,j,k+1)){
                return true;
            }
            if(solver(board,word,i,j-1,k+1)){
                return true;
            }
            if(solver(board,word,i,j+1,k+1)){
                return true;
            }
            board[i][j] = hold;
        }
        return false;
    }

}