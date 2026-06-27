class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(j<k){
            if(!dq.isEmpty() && nums[j]>dq.peekLast()){
                dq.pollLast();
                continue;
            }
            else{
                dq.offerLast(nums[j]);
            }
            j++;
            ans[i] = dq.peekFirst();
        }

        if(dq.peekFirst()==nums[i]){
            dq.pollFirst();
        }
        i++;

        while(j<nums.length){
            if(!dq.isEmpty() && nums[j]>dq.peekLast()){
                dq.pollLast();
                continue;
            }
            else{
                dq.offerLast(nums[j]);
            }
            ans[i] = dq.peekFirst();
            if(dq.peekFirst()==nums[i]){
                dq.pollFirst();
            }
            i++;j++;
        }

    return ans;
    }
}