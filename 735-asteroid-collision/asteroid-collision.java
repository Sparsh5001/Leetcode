class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int val : asteroids){
            if(val>0 || stack.isEmpty()){
                stack.push(val);
                continue;
            }else{
                if(val<0 && stack.peek()<0){
                    stack.push(val);
                    continue;
                }
                while(!stack.isEmpty() && val<0){
                    if(stack.peek()>0){
                        int val_top = stack.pop();
                        if(val*-1 > val_top){
                        }
                        else if(val*-1 == val_top){
                            break;
                        }
                        else{
                            val = val_top;
                            stack.push(val);
                            break;
                        }
                    }
                    if(stack.isEmpty() || stack.peek()<0){
                        stack.push(val);
                        break;
                    }  
                }
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1 ; i > -1 ; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}