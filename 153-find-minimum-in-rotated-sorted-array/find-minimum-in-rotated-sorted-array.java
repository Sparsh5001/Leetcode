class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid==0||mid==n-1){
                return Math.min(arr[start],arr[end]);
            }
            else if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                return arr[mid];
            }
            else{
                if(arr[mid]>arr[end]){
                    start=mid+1;
                    continue;
                }               
                end = mid-1;
            }
        }
    return arr[start];
    }
}