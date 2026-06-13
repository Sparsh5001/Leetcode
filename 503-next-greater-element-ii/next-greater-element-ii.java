class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[nums.length];

        for(int i = nums.length-1 ; i > -1 ; i--){
            stack.push(nums[i]);
        }


        for(int i = nums.length-1 ; i > -1 ; i--){
            while(!stack.isEmpty()){
                if(stack.peek() > nums[i]){
                    arr[i] = stack.peek();
                    stack.push(nums[i]);
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                arr[i] = -1;
                stack.push(nums[i]);
            }
        }



        return arr;

    }
}