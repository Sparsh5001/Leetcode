class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public void helper(char[][] board){

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j<9 ; j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    int box = (i/3)*3 + (j/3);
                    boxes[box].add(board[i][j]);
                }
            }
        }

        solver(board , rows , cols , boxes , 0 , 0);

    } 

    public boolean solver(char[][] board , Set<Character>[] rows , Set<Character>[] cols , Set<Character>[] boxes , int i , int j ){

        if(i==9){
            return true;
        }

        if(Character.isDigit(board[i][j])){
            if(j==8){
                return solver(board , rows , cols , boxes , i+1 , 0);
            }
            else{
                return solver(board , rows, cols , boxes , i , j+1);
            }
        }

        for(int k = 1 ; k <=9 ; k++){
            char c = (char) (k + '0');
            int box = (i / 3) * 3 + (j / 3);
            if(rows[i].contains(c) || cols[j].contains(c) || boxes[box].contains(c)){
                continue;
            }

            rows[i].add(c);
            cols[j].add(c);
            boxes[box].add(c);

            board[i][j] = c;

            if(j==8){
                if(solver(board , rows , cols , boxes , i+1 , 0)){
                    return true;
                }
            }
            else{
                if(solver(board , rows, cols , boxes , i , j+1)){
                    return true;
                }
            }

            rows[i].remove(c);
            cols[j].remove(c);
            boxes[box].remove(c);

            board[i][j] = '.';
        }
        return false;
    }
}