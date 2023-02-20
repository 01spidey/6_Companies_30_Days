class Solution {
    int n, mod = 1000000007;
    int[] arr;
    int[][] rank;
    long[][] store;

    public int numberOfCombinations(String num) {
        init(num);
        for(int i=n-1; i>-1; --i)
            if(arr[i] > 0)
                for(int j=n-1-i; j>-1; --j) {
                    if(j < n-1-i) { 
                        store[i][j] = store[i][j+1]; 
                        int k = i + j + 1; 
                      if(k+j < n) {
                            if(rank[i][j] <= rank[k][j]) 
                                store[i][j] += store[k][j];
                            else if(k+j+1 < n) 
                              store[i][j] += store[k][j+1];
                            if(store[i][j] > mod)
                                store[i][j] -= mod;
                        }
                    } else store[i][j] = 1; 
                }
        return (int) store[0][0];
    }
    
    private void init(String num) {
        n = num.length();
        arr = new int[n];
        int index = 0;
        for(char c: num.toCharArray())
            arr[index++] = (c - '0');
        rank = new int[n][];
        store = new long[n][];
        for(int i=0; i<n; ++i) {
            rank[i] = new int[n-i];
            store[i] = new long[n-i];
        }
        initRank();
    }

    private void initRank() {
        List<List<Integer>> groups = getSingleBucket();
        for(int j=0; j<n; ++j) {
            List<List<Integer>> newGroups = new LinkedList<>();
            for(List<Integer> group: groups) {
                List<Integer>[] buckets = new List[10];
                for(int i: group) {
                    int k = i + j;
                    if(k < n) {
                        int d = arr[k];
                        if(buckets[d] == null)
                            buckets[d] = new LinkedList<>();
                        buckets[d].add(i);
                    }
                }
                for(List<Integer> bucket: buckets) if(bucket != null)
                    newGroups.add(bucket);
            }
            int r = 0;
            for(List<Integer> group: newGroups) {
                for(int i: group) rank[i][j] = r;
                ++r;
            }
            groups = newGroups;
        }
    }
    
    private List<List<Integer>> getSingleBucket() {
        List<List<Integer>> groups = new LinkedList<>();
        List<Integer> seed = new LinkedList<>();
        for(int i=0; i<n; ++i)
            seed.add(i);
        groups.add(seed);
        return groups;
    }
}
