class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3=0, i5 = 0;
        for(int i=1;i<n;i++){
            int next_num = Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));

            if(next_num == nums[i2]*2){
                i2 +=1;
            } 
            if(next_num == nums[i3]*3){
                i3+=1;
            }
            if(next_num == nums[i5]*5){
                i5+=1;
            }
            nums[i] = next_num;
        }
        return nums[n-1];
    }
}