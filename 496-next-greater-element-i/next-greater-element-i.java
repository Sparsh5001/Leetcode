class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer , Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length-1 ; i>-1 ; i--){
            while(!stack.isEmpty()){
                if(stack.peek() > nums2[i]){
                    map.put(nums2[i] , stack.peek());
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                map.put(nums2[i] , -1);
            }
            
            stack.push(nums2[i]);
        }


        int[] arr = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            arr[i] = map.get(nums1[i]);
        }

        return arr;


    }
}