class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack_Nsr = new Stack<>();
        Stack<int[]> stack_Nsl = new Stack<>();

        int n = heights.length;

        //int[] nsr = new int[n];
        int[] nsl = new int[n];

        int max = 0;

        for(int i = 0 ; i<n ; i++){
            int x=0;
            if(!stack_Nsl.isEmpty()){
                x = stack_Nsl.peek()[1] + 1;
            }

            while(!stack_Nsl.isEmpty()){

                if(stack_Nsl.peek()[0] < heights[i]){
                    nsl[i] = stack_Nsl.peek()[1];
                    stack_Nsl.push( new int[]{heights[i] , x});
                    break;
                }
                else{
                    stack_Nsl.pop();
                }
            }

            if(stack_Nsl.isEmpty()){
                stack_Nsl.push(new int[]{heights[i] , x});
                nsl[i] = -1;
            }

        }


        for(int i = n-1 ; i>-1 ; i--){
            int x=n-1;
            int nsr=-99;
            if(!stack_Nsr.isEmpty()){
                x = stack_Nsr.peek()[1] - 1; 
            }

            while(!stack_Nsr.isEmpty()){

                if(stack_Nsr.peek()[0] < heights[i]){
                    nsr = stack_Nsr.peek()[1];
                    stack_Nsr.push( new int[]{heights[i] , x});
                    break;
                }
                else{
                    stack_Nsr.pop();
                }
            }

            if(stack_Nsr.isEmpty()){
                stack_Nsr.push(new int[]{heights[i] , x});
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