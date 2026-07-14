class Solution {
    public List<List<String>> solveNQueens(int n) {
        return helper(n);
    }

    public List<List<String>> helper(int n){
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int[][] board = new int[n][n];
        solver(ans , cur , board ,  0 );
        return ans;
    }

    public void solver(List<List<String>> ans ,List<String> cur , int[][] board , int i){
        if(i==board.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int k = 0 ; k<board.length ; k++){
            StringBuilder sb = new StringBuilder();
            if(check(board,i,k)){
                board[i][k]=1;
                for(int x=0 ; x<board.length ; x++){
                    if(x==k){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                cur.add(sb.toString());
                solver(ans,cur,board,i+1);
                cur.removeLast();
                board[i][k]=0;
            }
        }
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