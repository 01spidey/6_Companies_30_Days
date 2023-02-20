class Solution {
        public int maxSum(int[][] grid) {
        int maxSum = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                maxSum = Math.max(maxSum, findSum(grid, row, col));
            }
        }
        return maxSum;
    }

    private int findSum(int[][] grid, int row, int col){
        if ((row+2 < grid.length) && (col+2 < grid[0].length)){
            return grid[row][col] + grid[row][col+1] + grid[row][col+2] 
                    + grid[row+1][col+1] 
                    + grid[row+2][col] + grid[row+2][col+1]+ grid[row+2][col+2];
        }
        return 0;
    }
}
