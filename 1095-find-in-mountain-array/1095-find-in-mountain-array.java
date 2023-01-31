class Solution {
    int orderAgnosticBS(MountainArray arr, int target, int start, int end){
        boolean isAsc = (arr.get(start) < arr.get(end));
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr.get(mid) == target){
                return mid;
            }
            if(isAsc){
                if(arr.get(mid) > target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(arr.get(mid) > target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        int peakIdx = start;
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peakIdx);
        if(firstTry != -1){
            return firstTry;
        }
        return orderAgnosticBS(mountainArr, target, peakIdx+1, mountainArr.length()-1);
    }
}