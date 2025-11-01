class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];
        for(int i = 0; i < n ; i++){
            answer[i] = i;
        }


        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if( answer[j]>-1 && grid[i][answer[j]] == 1){
                    if(answer[j]+1 == n || grid[i][answer[j]+1] == -1){
                        answer[j]=-1;
                    }
                    else if(grid[i][answer[j]+1] == 1){
                        answer[j]+=1;
                    }
                }

                else if(answer[j]>-1){
                    if(answer[j]==0 || grid[i][answer[j]-1] == 1){
                        answer[j]=-1;
                    }
                    else{
                        answer[j]-=1;
                    }
                }
            }
        }
        
        return answer;
    }
}