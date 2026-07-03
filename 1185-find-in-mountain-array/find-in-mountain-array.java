/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 1 ;
        int end = n-2;
        int mid = 0;
        //finding peak here
        while(start<=end){
            mid=start+(end-start)/2;
            int val_mid = mountainArr.get(mid);
            int val_prev = mountainArr.get(mid-1);
            int val_next = mountainArr.get(mid+1);

            if(val_mid>val_prev && val_mid>val_next){
                break;
            }
            else{
                if(val_prev>val_next){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        int a = BinarySearch(target,0,mid,mountainArr,n,true);//search in left array , which is sorted in asc
        int b = BinarySearch(target,mid+1,n-1,mountainArr,n,false);//search in right array , sorted in desc
        //System.out.println(a);
        //System.out.println(b);
        if(a==-1){
            return b;
        }
        if(b==-1){
            return a;
        }
        return Math.min(a,b);
    }

    public int BinarySearch(int target , int start , int end , MountainArray mountainArr ,int n ,boolean asc){

        while(start<=end){
            int mid=start+(end-start)/2;
            int val = mountainArr.get(mid);
            if(val==target){
                return mid;
            }
            if(val>target && asc){
                end=mid-1;
            }
            else if(val>target && !asc){
                start=mid+1;
                //System.out.println(val);
            }

            if(val<target && asc){
                start=mid+1;
            }
            else if(val<target && !asc){
                end=mid-1;
            }
        }
    return -1;
    }
}