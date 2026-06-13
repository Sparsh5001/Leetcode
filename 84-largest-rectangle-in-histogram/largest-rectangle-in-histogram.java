class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack = new Stack<>();

        int n = heights.length;

        //int[] nsr = new int[n];
        int[] nsl = new int[n];

        int max = 0;

        for(int i = 0 ; i<n ; i++){
            int x=0;
            if(!stack.isEmpty()){
                x = stack.peek()[1] + 1;
            }

            while(!stack.isEmpty()){

                if(stack.peek()[0] < heights[i]){
                    nsl[i] = stack.peek()[1];
                    stack.push( new int[]{heights[i] , x});
                    break;
                }
                else{
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                stack.push(new int[]{heights[i] , x});
                nsl[i] = -1;
            }

        }

        stack.clear();

        for(int i = n-1 ; i>-1 ; i--){
            int x=n-1;
            int nsr=-99;
            if(!stack.isEmpty()){
                x = stack.peek()[1] - 1; 
            }

            while(!stack.isEmpty()){

                if(stack.peek()[0] < heights[i]){
                    nsr = stack.peek()[1];
                    stack.push( new int[]{heights[i] , x});
                    break;
                }
                else{
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                stack.push(new int[]{heights[i] , x});
                nsr = -1;
            }

            int nsl_sum;
            int nsr_sum;
            if(nsl[i] == -1){
                 nsl_sum = (i+1)*heights[i];
            }else{
                 nsl_sum = (i-nsl[i])*heights[i];
            }

            if(nsr == -1){
                 nsr_sum = (n-i-1)*heights[i];
            }else{
                 nsr_sum = (nsr-i-1)*heights[i];
            }

            if(nsr_sum + nsl_sum > max){
                max = nsr_sum + nsl_sum;
            }

        }

        return max;
    }

}