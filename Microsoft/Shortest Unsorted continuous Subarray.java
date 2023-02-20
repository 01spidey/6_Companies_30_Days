class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        
        Arrays.sort(sortedNums);
        int begin = 0;
        int end = 0;
        
        boolean foundBeginning = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i] && !foundBeginning) {
                begin = i;
                foundBeginning = true;
            }
            
            if (nums[i] != sortedNums[i] && foundBeginning) {
                end = i;
            }            
        }
        
        if (end == begin) {
            return 0;
        }
        
        return end - begin + 1;
    }
}
