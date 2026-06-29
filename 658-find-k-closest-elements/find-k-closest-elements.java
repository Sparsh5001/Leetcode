class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 1 ;
        int j = k ;
        int start = 0 ;
        int end = k-1 ; 

        while(j<arr.length){
            int a = arr[j];
            int b = arr[i-1];

            if(Math.abs(a-x)<Math.abs(b-x)){
                start=i;
                end=j;
            }
            else if(Math.abs(a-x)==Math.abs(b-x) && a<b){
                start=i;
                end=j;
            }
        i++;
        j++;
        }
    List<Integer> l = new ArrayList<>();
    for(int z = start ; z<end+1 ;z++){
        l.add(arr[z]);
    }
    return l;   
    }
}