class Solution {
    
    public long rev(long n){
        long out = 0, rem = 0;
        while(n != 0){  
            rem = n % 10;  
            out = out * 10 + rem;  
            n = n/10;  
        }  
        return out;
    }

    public int countNicePairs(int[] nums) {
        
        HashMap<Long, Long> map = new HashMap<>();
        HashSet<Long> set = new HashSet<>();
        long temp;
        
        for(long i : nums){
            temp = i-rev(i);
            set.add(temp);
            if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
            else map.put(temp, 1l);
        }

        long tot =  0;
        long n = 0;

        for(long i:set){
            n = map.get(i);
            if(n>=2) tot+=((n*(n-1))/2);
        }
        
        return (int)(tot%1000000007);
    }
}
