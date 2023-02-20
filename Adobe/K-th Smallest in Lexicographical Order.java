class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int prefix = 1;
        while(cur < k){
            int temp = helper(n, prefix);
            if(temp + cur - 1 >= k){
                prefix *= 10;
                cur ++;
            }else{
                cur += temp;
                prefix ++;
            }
        }
        return prefix;
    }
    
    private int helper(int n, int prefix){
        long next = prefix + 1;
        long cur = prefix;
        int count = 0;
        while(cur <= n){
            count += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        
        return count;
    }
}
