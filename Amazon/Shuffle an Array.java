class Solution {
    private int[] nums, temp;
    private Random rand = new Random();
    private int ind, c;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        temp = Arrays.copyOf(nums, nums.length);

        for(int i=0;i<nums.length;i++){
            ind = i+rand.nextInt(nums.length-i);
            c = temp[i]; 
            temp[i] = temp[ind]; 
            temp[ind] = c;
        }

        return temp;
    }
}
