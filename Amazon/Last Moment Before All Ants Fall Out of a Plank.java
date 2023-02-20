class Solution {
public int getLastMoment(int n, int[] left, int[] right) {
    int maxLeft = 0;
    for(int i=0; i<left.length; i++){
        maxLeft = Math.max(maxLeft, left[i]);
    }
    int time1 = Math.abs(0-maxLeft);
    
    int minRight = Integer.MAX_VALUE;
    for(int i=0; i<right.length; i++){
        minRight = Math.min(minRight, right[i]);
    }
    minRight = minRight == Integer.MAX_VALUE ? n : minRight;
    int time2 = n - minRight;
        
    return Math.max(time1, time2);
}
}
