class Solution {
    int[][] dp = new int[3001][1001];
    int mod = 1000000007;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        for(int i=0;i<=3000;i++){
            for(int j=0;j<=k;j++)
                dp[i][j] = -1;
        }         
        return dfs(startPos, endPos, k);
    }
    
    private int dfs(int pos, int target, int k){
        if(k == 0){
            if(pos == target)
                return 1;
            return 0;
        }
        
        if(dp[pos+1000][k] != -1)
            return dp[pos+1000][k];
        
        int l = dfs(pos-1, target, k-1);
        int r = dfs(pos+1, target, k-1);
        
        dp[pos+1000][k] = ((l%mod)+(r%mod))%mod;
        
        return dp[pos+1000][k];
    }
}
