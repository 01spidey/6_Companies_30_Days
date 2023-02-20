class Solution {
    public int gcd(int a, int b){
        if (a == 0) return b;
        return gcd(b % a, a);
    }


    public int minOperations(int[] nums, int[] Divs) {
        int res = Divs[0];

        for(int num:Divs){
            if(res==1) break;
            res = gcd(res, num);
        }

        HashSet<Integer> set = new HashSet<>();
        
        System.out.println(res);

        int count = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(res%nums[i]==0) return count;
            else count++;
        }

        return -1;



    }
}
