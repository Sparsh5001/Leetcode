class Solution {
    public boolean makesquare(int[] matchsticks) {
        return helper(matchsticks);
    }

    public boolean helper(int[] sticks){
        boolean[] used = new boolean[sticks.length];
        int total = 0;
        for(int stick : sticks){
            total+=stick;
        }
        if(total%4!=0){
            return false;
        }
        int parts = 0 ;
        int cur_sum = 0 ;
        int req_sum = total/4;
        Arrays.sort(sticks);

        return solver(sticks , parts , used , cur_sum , req_sum , 0);
    }


    public boolean solver(int[] sticks , int parts , boolean[]used , int cur_sum , int req_sum , int k){

            if(parts==4){
                for(int i = 0 ; i < used.length ; i++){
                    if(!used[i]){
                        return false;
                    }
                }
                return true;
            }


            if(cur_sum == req_sum){
                if(solver(sticks,parts+1,used,0,req_sum,0)){
                    return true;
                }
            }

            if(cur_sum>req_sum){
                return false;
            }
            while(k<sticks.length){
                if(used[k]){
                    k++;
                    continue;
                }
                used[k]=true;
                int last_check = k;
                if(solver(sticks,parts,used,cur_sum+sticks[k],req_sum,k+1)){
                    return true;
                }
                used[k]=false;
                do{
                    k++;
                }while(k<sticks.length-1 && sticks[k+1]==sticks[last_check]);
                
            }
        return false;
    }
}