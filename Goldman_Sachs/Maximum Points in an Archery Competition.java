class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maximumBobPoints(numArrows, aliceArrows, 11, 0);
        return result;
    }
    int[] result = new int[12];
    int [] temp = new int[12];
    int max = 0;
    public void maximumBobPoints(int numArrows, int[] aliceArrows, int arrowIndex, int currentScore) {
        if(numArrows<0)
            return;

            if(currentScore>=max){
                max = currentScore;
                for(int i=0;i<result.length;i++){
                    result[i] = temp[i];
                }
            }

        if(numArrows==0)
            return;

        temp[arrowIndex] = (arrowIndex==0)?numArrows:(aliceArrows[arrowIndex]+1);
        
        maximumBobPoints(numArrows-temp[arrowIndex], aliceArrows, arrowIndex-1, currentScore + arrowIndex);
        
        temp[arrowIndex] = (arrowIndex==0)?numArrows:0;
        maximumBobPoints(numArrows-temp[arrowIndex], aliceArrows, arrowIndex-1, currentScore);
        temp[arrowIndex]  = 0;

    }
}
